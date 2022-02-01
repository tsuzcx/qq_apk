package com.tencent.qapmsdk.common.ssl;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/ssl/SslFactory;", "", "()V", "DEFAULT_SSL_CONTEXT", "Lcom/tencent/qapmsdk/common/ssl/ISslContextBuilder;", "value", "sslBuilder", "getSslBuilder", "()Lcom/tencent/qapmsdk/common/ssl/ISslContextBuilder;", "setSslBuilder", "(Lcom/tencent/qapmsdk/common/ssl/ISslContextBuilder;)V", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "common_release"}, k=1, mv={1, 1, 15})
public final class SslFactory
{
  @JvmField
  @NotNull
  public static final ISslContextBuilder DEFAULT_SSL_CONTEXT = (ISslContextBuilder)new DefaultSslContextBuilder();
  public static final SslFactory INSTANCE = new SslFactory();
  @Nullable
  private static ISslContextBuilder sslBuilder = DEFAULT_SSL_CONTEXT;
  @Nullable
  private static final SSLSocketFactory sslSocketFactory;
  
  @Nullable
  public final ISslContextBuilder getSslBuilder()
  {
    ISslContextBuilder localISslContextBuilder = sslBuilder;
    if (localISslContextBuilder != null) {
      return localISslContextBuilder;
    }
    return DEFAULT_SSL_CONTEXT;
  }
  
  @Nullable
  public final SSLSocketFactory getSslSocketFactory()
  {
    Object localObject = sslSocketFactory;
    if (localObject != null) {
      return localObject;
    }
    localObject = getSslBuilder();
    if (localObject != null)
    {
      localObject = ((ISslContextBuilder)localObject).build();
      if (localObject != null) {
        return ((SSLContext)localObject).getSocketFactory();
      }
    }
    return null;
  }
  
  public final void setSslBuilder(@Nullable ISslContextBuilder paramISslContextBuilder)
  {
    try
    {
      sslBuilder = paramISslContextBuilder;
      paramISslContextBuilder = Unit.INSTANCE;
      return;
    }
    finally
    {
      paramISslContextBuilder = finally;
      throw paramISslContextBuilder;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.ssl.SslFactory
 * JD-Core Version:    0.7.0.1
 */