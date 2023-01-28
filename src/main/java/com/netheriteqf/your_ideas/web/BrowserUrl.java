package com.netheriteqf.your_ideas.web;

/**
 * @author Goulixiaoji
 */
public class BrowserUrl {
    public static void browserUrl(String url) throws Exception {
        // 获取操作系统的名字
        final var osName = System.getProperty("os.name", "");
        if (osName.startsWith("Mac OS")) {
            // 苹果的打开方式
            final var fileMgr = Class.forName("com.apple.eio.FileManager");
            final var openURL = fileMgr.getDeclaredMethod("openURL", String.class);
            openURL.invoke(null, url);
        }
        else if (osName.startsWith("Windows")) {
            // windows的打开方式。
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        else {
            // Unix or Linux的打开方式
            String[] browsers = {"firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape"};
            String browser = null;
            for (int count = 0; count < browsers.length && browser == null; count++) {
                // 执行代码，在browser有值后跳出，
                // 这里是如果进程创建成功了，==0是表示正常结束。
                if (Runtime.getRuntime().exec(new String[]{"which", browsers[count]}).waitFor() == 0) {
                    browser = browsers[count];
                }
            }
            if (browser == null) {
                throw new Exception("Could not find web browser");
            }
            else {
                // 这个值在上面已经成功地得到了一个进程。
                Runtime.getRuntime().exec(new String[]{browser, url});
            }
        }
    }
}
