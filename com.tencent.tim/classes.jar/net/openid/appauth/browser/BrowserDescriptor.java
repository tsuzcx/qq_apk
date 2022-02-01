package net.openid.appauth.browser;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BrowserDescriptor
{
  private static final String DIGEST_SHA_512 = "SHA-512";
  private static final int PRIME_HASH_FACTOR = 92821;
  public final String packageName;
  public final Set<String> signatureHashes;
  public final Boolean useCustomTab;
  public final String version;
  
  public BrowserDescriptor(@NonNull PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    this(paramPackageInfo.packageName, generateSignatureHashes(paramPackageInfo.signatures), paramPackageInfo.versionName, paramBoolean);
  }
  
  public BrowserDescriptor(@NonNull String paramString1, @NonNull Set<String> paramSet, @NonNull String paramString2, boolean paramBoolean)
  {
    this.packageName = paramString1;
    this.signatureHashes = paramSet;
    this.version = paramString2;
    this.useCustomTab = Boolean.valueOf(paramBoolean);
  }
  
  @NonNull
  public static String generateSignatureHash(@NonNull Signature paramSignature)
  {
    try
    {
      paramSignature = Base64.encodeToString(MessageDigest.getInstance("SHA-512").digest(paramSignature.toByteArray()), 10);
      return paramSignature;
    }
    catch (NoSuchAlgorithmException paramSignature)
    {
      throw new IllegalStateException("Platform does not supportSHA-512 hashing");
    }
  }
  
  @NonNull
  public static Set<String> generateSignatureHashes(@NonNull Signature[] paramArrayOfSignature)
  {
    HashSet localHashSet = new HashSet();
    int j = paramArrayOfSignature.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(generateSignatureHash(paramArrayOfSignature[i]));
      i += 1;
    }
    return localHashSet;
  }
  
  @NonNull
  public BrowserDescriptor changeUseCustomTab(boolean paramBoolean)
  {
    return new BrowserDescriptor(this.packageName, this.signatureHashes, this.version, paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof BrowserDescriptor))) {
        return false;
      }
      paramObject = (BrowserDescriptor)paramObject;
    } while ((this.packageName.equals(paramObject.packageName)) && (this.version.equals(paramObject.version)) && (this.useCustomTab == paramObject.useCustomTab) && (this.signatureHashes.equals(paramObject.signatureHashes)));
    return false;
  }
  
  public int hashCode()
  {
    int j = this.packageName.hashCode();
    int k = this.version.hashCode();
    if (this.useCustomTab.booleanValue()) {}
    for (int i = 1;; i = 0)
    {
      Iterator localIterator = this.signatureHashes.iterator();
      i += 92821 * (j * 92821 + k);
      while (localIterator.hasNext()) {
        i = ((String)localIterator.next()).hashCode() + i * 92821;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.browser.BrowserDescriptor
 * JD-Core Version:    0.7.0.1
 */