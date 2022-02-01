
package moai.view.moaiphoto.log;

import android.util.Log;

/**
 * class that holds the {@link Logger} for this library, defaults to {@link LoggerDefault} to send logs to android {@link Log}
 */
public final class LogManager {

    private static Logger logger = new LoggerDefault();

    public static void setLogger(Logger newLogger) {
        logger = newLogger;
    }

    public static Logger getLogger() {
        return logger;
    }

}
