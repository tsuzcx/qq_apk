package cooperation.qqreader.js;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import avmz;
import java.util.Arrays;

public class JsCallParams
  implements Parcelable
{
  public static final Parcelable.Creator<JsCallParams> CREATOR = new avmz();
  private String[] args;
  private String method;
  private String pkgName;
  private String url;
  
  private JsCallParams(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.pkgName = paramParcel.readString();
    this.method = paramParcel.readString();
    this.args = paramParcel.createStringArray();
  }
  
  public JsCallParams(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    this.url = paramString1;
    this.pkgName = paramString2;
    this.method = paramString3;
    this.args = paramArrayOfString;
  }
  
  public boolean a(JsCallParams paramJsCallParams)
  {
    return (TextUtils.equals(this.url, paramJsCallParams.url)) && (TextUtils.equals(this.method, paramJsCallParams.method)) && (TextUtils.equals(this.pkgName, paramJsCallParams.pkgName)) && (Arrays.equals(this.args, paramJsCallParams.args));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String[] getArgs()
  {
    return this.args;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public String getPkgName()
  {
    return this.pkgName;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.pkgName);
    paramParcel.writeString(this.method);
    paramParcel.writeStringArray(this.args);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.js.JsCallParams
 * JD-Core Version:    0.7.0.1
 */