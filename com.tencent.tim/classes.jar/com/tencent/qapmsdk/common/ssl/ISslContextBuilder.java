package com.tencent.qapmsdk.common.ssl;

import javax.net.ssl.SSLContext;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/ssl/ISslContextBuilder;", "", "sslContext", "Ljavax/net/ssl/SSLContext;", "getSslContext", "()Ljavax/net/ssl/SSLContext;", "build", "initSslContext", "", "ssl", "common_release"}, k=1, mv={1, 1, 15})
public abstract interface ISslContextBuilder
{
  @Nullable
  public abstract SSLContext build();
  
  @Nullable
  public abstract SSLContext getSslContext();
  
  public abstract void initSslContext(@NotNull SSLContext paramSSLContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.ssl.ISslContextBuilder
 * JD-Core Version:    0.7.0.1
 */