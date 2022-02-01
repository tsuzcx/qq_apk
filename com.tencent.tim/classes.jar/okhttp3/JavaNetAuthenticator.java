package okhttp3;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.List;
import okhttp3.internal.annotations.EverythingIsNonNull;

@EverythingIsNonNull
public final class JavaNetAuthenticator
  implements Authenticator
{
  private InetAddress getConnectToInetAddress(Proxy paramProxy, HttpUrl paramHttpUrl)
    throws IOException
  {
    if ((paramProxy != null) && (paramProxy.type() != Proxy.Type.DIRECT)) {
      return ((InetSocketAddress)paramProxy.address()).getAddress();
    }
    return InetAddress.getByName(paramHttpUrl.host());
  }
  
  public Request authenticate(Route paramRoute, Response paramResponse)
    throws IOException
  {
    List localList = paramResponse.challenges();
    Object localObject = paramResponse.request();
    HttpUrl localHttpUrl = ((Request)localObject).url();
    if (paramResponse.code() == 407) {}
    Challenge localChallenge;
    for (int i = 1;; i = 0)
    {
      paramResponse = paramRoute.proxy();
      int k = localList.size();
      int j = 0;
      for (;;)
      {
        if (j >= k) {
          break label256;
        }
        localChallenge = (Challenge)localList.get(j);
        if ("Basic".equalsIgnoreCase(localChallenge.scheme())) {
          break;
        }
        j += 1;
      }
    }
    if (i != 0)
    {
      paramRoute = (InetSocketAddress)paramResponse.address();
      paramRoute = java.net.Authenticator.requestPasswordAuthentication(paramRoute.getHostName(), getConnectToInetAddress(paramResponse, localHttpUrl), paramRoute.getPort(), localHttpUrl.scheme(), localChallenge.realm(), localChallenge.scheme(), localHttpUrl.url(), Authenticator.RequestorType.PROXY);
      label150:
      if (paramRoute == null) {
        break label248;
      }
      paramResponse = Credentials.basic(paramRoute.getUserName(), new String(paramRoute.getPassword()), localChallenge.charset());
      localObject = ((Request)localObject).newBuilder();
      if (i == 0) {
        break label250;
      }
    }
    label248:
    label250:
    for (paramRoute = "Proxy-Authorization";; paramRoute = "Authorization")
    {
      return ((Request.Builder)localObject).header(paramRoute, paramResponse).build();
      paramRoute = java.net.Authenticator.requestPasswordAuthentication(localHttpUrl.host(), getConnectToInetAddress(paramResponse, localHttpUrl), localHttpUrl.port(), localHttpUrl.scheme(), localChallenge.realm(), localChallenge.scheme(), localHttpUrl.url(), Authenticator.RequestorType.SERVER);
      break label150;
      break;
    }
    label256:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.JavaNetAuthenticator
 * JD-Core Version:    0.7.0.1
 */