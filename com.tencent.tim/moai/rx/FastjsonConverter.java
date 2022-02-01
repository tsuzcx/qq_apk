package moai.rx;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.common.io.Closeables;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import moai.io.Caches;
import moai.proxy.JavaBeanProxy;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * Created by ayangxu.
 */
public class FastjsonConverter implements Converter {

    private static final String ERR_CODE_KEY = "errcode";
    private static final String ERR_MSG_KEY = "errmsg";

    private static class CommonErrorException extends RuntimeException {
        final ServiceException serviceException;

        private CommonErrorException(ServiceException serviceException) {
            this.serviceException = serviceException;
        }
    }

    private static class CommonErrorProcessor implements ExtraProcessor {
        int errCode = -1;
        String errMsg = null;
        @Override
        public void processExtra(Object o, String s, Object o1) {
            if (o1 != null) {
                if (ERR_CODE_KEY.equals(s)) {
                    errCode = TypeUtils.castToInt(o1);
                } else if (ERR_MSG_KEY.equals(s)) {
                    errMsg = TypeUtils.castToString(o1);
                }
                if (errCode != -1 && errMsg != null) {
                    throw new CommonErrorException(new ServiceException(errMsg, errCode));
                }
            }
        }
    }

    public FastjsonConverter() {

    }

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {
        long start = System.currentTimeMillis();
        Object ret = null;
        InputStream in = null;
        int length = 0;
        try {
            String json = Caches.toString((in = body.in()));
            length = json.length();

            CommonErrorProcessor processor = null;
            if (length < 256) {
                processor = new CommonErrorProcessor();
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                try {
                    // FIXME 好像只能够处理一级泛型，这种好像暂时没办法处理：[[Object,Object...]]
                    Type type0 = parameterizedType.getActualTypeArguments()[0];

                    if (type0 instanceof Iterable) {
                        ret = JSON.parseArray(json, (Class<?>) type0);
                    } else {
                        ret = JSON.parseObject(json, type, processor);
                    }

                    if (processor != null && processor.errCode != -1) {
                        throw new ServiceException(processor.errMsg, processor.errCode);
                    }
                } catch (JSONException ex) {
                    throw new ServiceException(ex.getMessage(), -1);
                }
            } else {
                ret = JSON.parseObject(json, type, processor);
                if (processor != null && processor.errCode != -1) {
                    throw new ServiceException(processor.errMsg, processor.errCode);
                }
            }
        } catch (CommonErrorException e) {
            throw e.serviceException;
        } catch (IOException e) {
        	throw new ConversionException(e);
        } finally {
            Closeables.closeQuietly(in);
        }
        Log.d("json", "fromBody -> size: " + length + ", cost: +" + (System.currentTimeMillis() - start) + "ms");
        return ret;
    }

    @Override
    public TypedOutput toBody(Object object) {
        return new JsonTypedOutput(JSON.toJSONString(object, new PropertyPreFilter() {
            @Override
            public boolean apply(JSONSerializer serializer, Object object, String name) {
                return JavaBeanProxy.has(object, name);
            }
        }).getBytes(), "UTF-8");
    }

    private static class JsonTypedOutput implements TypedOutput {
        private final byte[] jsonBytes;
        private final String mimeType;

        JsonTypedOutput(byte[] jsonBytes, String encode) {
            this.jsonBytes = jsonBytes;
            this.mimeType = "application/json; charset=" + encode;
        }

        @Override public String fileName() {
            return null;
        }

        @Override public String mimeType() {
            return mimeType;
        }

        @Override public long length() {
            return jsonBytes.length;
        }

        @Override public void writeTo(OutputStream out) throws IOException {
            out.write(jsonBytes);
        }
    }

    public void test() {}
}
