package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

class JdkWithJettyBootPlatform
  extends Platform
{
  private final Class<?> clientProviderClass;
  private final Method getMethod;
  private final Method putMethod;
  private final Method removeMethod;
  private final Class<?> serverProviderClass;
  
  JdkWithJettyBootPlatform(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
  {
    this.putMethod = paramMethod1;
    this.getMethod = paramMethod2;
    this.removeMethod = paramMethod3;
    this.clientProviderClass = paramClass1;
    this.serverProviderClass = paramClass2;
  }
  
  public static Platform buildIfSupported()
  {
    try
    {
      Object localObject = Class.forName("org.eclipse.jetty.alpn.ALPN");
      Class localClass1 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
      Class localClass2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
      Class localClass3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
      localObject = new JdkWithJettyBootPlatform(((Class)localObject).getMethod("put", new Class[] { SSLSocket.class, localClass1 }), ((Class)localObject).getMethod("get", new Class[] { SSLSocket.class }), ((Class)localObject).getMethod("remove", new Class[] { SSLSocket.class }), localClass2, localClass3);
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label140:
      break label140;
    }
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket)
  {
    try
    {
      this.removeMethod.invoke(null, new Object[] { paramSSLSocket });
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw Util.assertionError("unable to remove alpn", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label19:
      break label19;
    }
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    Object localObject = alpnProtocolNames(paramList);
    try
    {
      paramString = Platform.class.getClassLoader();
      paramList = this.clientProviderClass;
      Class localClass = this.serverProviderClass;
      localObject = new JettyNegoProvider((List)localObject);
      paramString = Proxy.newProxyInstance(paramString, new Class[] { paramList, localClass }, (InvocationHandler)localObject);
      this.putMethod.invoke(null, new Object[] { paramSSLSocket, paramString });
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw Util.assertionError("unable to set alpn", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label77:
      break label77;
    }
  }
  
  @Nullable
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    try
    {
      paramSSLSocket = (JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
      if ((!paramSSLSocket.unsupported) && (paramSSLSocket.selected == null))
      {
        Platform.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
        return null;
      }
      if (paramSSLSocket.unsupported) {
        paramSSLSocket = null;
      } else {
        paramSSLSocket = paramSSLSocket.selected;
      }
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw Util.assertionError("unable to get selected protocol", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label70:
      break label70;
    }
    return paramSSLSocket;
  }
  
  static class JettyNegoProvider
    implements InvocationHandler
  {
    private final List<String> protocols;
    String selected;
    boolean unsupported;
    
    JettyNegoProvider(List<String> paramList)
    {
      this.protocols = paramList;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = Util.EMPTY_STRING_ARRAY;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.valueOf(true);
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.unsupported = true;
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0)) {
        return this.protocols;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int j = paramObject.size();
        int i = 0;
        while (i < j)
        {
          if (this.protocols.contains(paramObject.get(i)))
          {
            paramObject = (String)paramObject.get(i);
            this.selected = paramObject;
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)this.protocols.get(0);
        this.selected = paramObject;
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        this.selected = ((String)paramObject[0]);
        return null;
      }
      return paramMethod.invoke(this, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.platform.JdkWithJettyBootPlatform
 * JD-Core Version:    0.7.0.1
 */