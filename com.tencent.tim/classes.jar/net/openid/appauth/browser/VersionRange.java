package net.openid.appauth.browser;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class VersionRange
{
  public static final VersionRange ANY_VERSION = new VersionRange(null, null);
  private DelimitedVersion mLowerBound;
  private DelimitedVersion mUpperBound;
  
  public VersionRange(@Nullable DelimitedVersion paramDelimitedVersion1, @Nullable DelimitedVersion paramDelimitedVersion2)
  {
    this.mLowerBound = paramDelimitedVersion1;
    this.mUpperBound = paramDelimitedVersion2;
  }
  
  public static VersionRange atLeast(String paramString)
  {
    return atLeast(DelimitedVersion.parse(paramString));
  }
  
  public static VersionRange atLeast(DelimitedVersion paramDelimitedVersion)
  {
    return new VersionRange(paramDelimitedVersion, null);
  }
  
  public static VersionRange atMost(String paramString)
  {
    return atMost(DelimitedVersion.parse(paramString));
  }
  
  public static VersionRange atMost(DelimitedVersion paramDelimitedVersion)
  {
    return new VersionRange(null, paramDelimitedVersion);
  }
  
  public static VersionRange between(String paramString1, String paramString2)
  {
    return new VersionRange(DelimitedVersion.parse(paramString1), DelimitedVersion.parse(paramString2));
  }
  
  public boolean matches(@NonNull String paramString)
  {
    return matches(DelimitedVersion.parse(paramString));
  }
  
  public boolean matches(@NonNull DelimitedVersion paramDelimitedVersion)
  {
    if ((this.mLowerBound != null) && (this.mLowerBound.compareTo(paramDelimitedVersion) > 0)) {}
    while ((this.mUpperBound != null) && (this.mUpperBound.compareTo(paramDelimitedVersion) < 0)) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    if (this.mLowerBound == null)
    {
      if (this.mUpperBound == null) {
        return "any version";
      }
      return this.mUpperBound.toString() + " or lower";
    }
    if (this.mUpperBound != null) {
      return "between " + this.mLowerBound + " and " + this.mUpperBound;
    }
    return this.mLowerBound.toString() + " or higher";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.browser.VersionRange
 * JD-Core Version:    0.7.0.1
 */