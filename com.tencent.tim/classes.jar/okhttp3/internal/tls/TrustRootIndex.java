package okhttp3.internal.tls;

import java.security.cert.X509Certificate;

public abstract interface TrustRootIndex
{
  public abstract X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.tls.TrustRootIndex
 * JD-Core Version:    0.7.0.1
 */