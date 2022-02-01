package moai.rx;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.Closeables;

import java.io.IOException;
import java.io.InputStream;

import javax.net.ssl.SSLException;

import moai.io.Caches;
import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.RetryError;
import retrofit.client.Response;

public abstract class RxNetworkErrorHandler implements ErrorHandler {
	@Override
    public Throwable handleError(RetrofitError cause) {
        try {
	        if (cause.getResponse() != null) {
		        JSONObject json = convertJson(cause);

                logResponseError(cause, cause.getResponse(), json);
		        if (json == null) {
			        return cause;
		        }
		        if (whetherNeedToRetry(cause, json)) {
					return throwRetryError(cause);
				} else {
					return throwError(cause, json);
				}
	        } else {
                logResponseError(cause, null, null);
				if (cause.getCause() instanceof SSLException) {
					return throwRetryError(cause);
				}

		        return cause;
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return cause;
    }

	public abstract boolean whetherNeedToRetry(RetrofitError cause, JSONObject json);
	public abstract Throwable throwError(RetrofitError cause, JSONObject json);
	private RetryError throwRetryError(RetrofitError cause) {
		return new RetryError(cause);
	}
	private static JSONObject convertJson(RetrofitError cause) {
		JSONObject json = null;
        InputStream in = null;
    	try {
    		json = JSON.parseObject(Caches.toString(in = cause.getResponse().getBody().in()));
		} catch (IOException ignored) {
		} finally {
			Closeables.closeQuietly(in);
	    }
		return json;
    }

    /**
     * 纪录网络返回的错误
     */
    protected void logResponseError(@NonNull RetrofitError cause, Response response,
                                    @Nullable JSONObject json) {}
}
