package utils;

import com.microsoft.playwright.*;

public class PlaywrightManager {


        private static Playwright playwright;
        private static Browser browser;
        private static BrowserContext browserContext;
        private static Page page;

        // Private constructor to prevent instantiation
        private PlaywrightManager() {}

        // Initialize Playwright and Browser
        public static void initializePlaywright() {
            System.setProperty("PLAYWRIGHT_BROWSERS_PATH", "D:\\playwright-browsers");
            if (playwright == null) {
                playwright = Playwright.create();
            }
            if (browser == null) {
//                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                 browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setChannel("chrome") // Use Chrome browser
                        .setHeadless(true));
            }
            if (browserContext == null) {
                browserContext = browser.newContext();
            }
            if (page == null) {
                page = browserContext.newPage();
            }
        }

        // Get the Page instance
        public static Page getPage() {
            if (page == null) {
                throw new IllegalStateException("Playwright is not initialized. Call initializePlaywright() first.");
            }
            return page;
        }

        // Tear down Playwright and Browser
        public static void tearDown() {
            if (page != null) {
                page.close();
                page = null;
            }
            if (browserContext != null) {
                browserContext.close();
                browserContext = null;
            }
            if (browser != null) {
                browser.close();
                browser = null;
            }
            if (playwright != null) {
                playwright.close();
                playwright = null;
            }
        }
}

