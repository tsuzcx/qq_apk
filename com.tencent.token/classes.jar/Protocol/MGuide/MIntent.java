package Protocol.MGuide;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class MIntent
  extends JceStruct
{
  static Map<String, String> a = new HashMap();
  static ArrayList<MBundle> b;
  public String mAction = "";
  public Map<String, String> mCategories = null;
  public String mClass = "";
  public ArrayList<MBundle> mExtras = null;
  public int mFlags = 0;
  public String mPackage = "";
  public String mType = "";
  public String mUidKey = "";
  public String mUri = "";
  
  static
  {
    a.put("", "");
    b = new ArrayList();
    MBundle localMBundle = new MBundle();
    b.add(localMBundle);
  }
  
  public JceStruct newInit()
  {
    return new MIntent();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mAction = paramJceInputStream.readString(0, false);
    this.mUri = paramJceInputStream.readString(1, false);
    this.mType = paramJceInputStream.readString(2, false);
    this.mPackage = paramJceInputStream.readString(3, false);
    this.mClass = paramJceInputStream.readString(4, false);
    this.mFlags = paramJceInputStream.read(this.mFlags, 5, false);
    this.mCategories = ((Map)paramJceInputStream.read(a, 6, false));
    this.mExtras = ((ArrayList)paramJceInputStream.read(b, 7, false));
    this.mUidKey = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mAction != null) {
      paramJceOutputStream.write(this.mAction, 0);
    }
    if (this.mUri != null) {
      paramJceOutputStream.write(this.mUri, 1);
    }
    if (this.mType != null) {
      paramJceOutputStream.write(this.mType, 2);
    }
    if (this.mPackage != null) {
      paramJceOutputStream.write(this.mPackage, 3);
    }
    if (this.mClass != null) {
      paramJceOutputStream.write(this.mClass, 4);
    }
    if (this.mFlags != 0) {
      paramJceOutputStream.write(this.mFlags, 5);
    }
    if (this.mCategories != null) {
      paramJceOutputStream.write(this.mCategories, 6);
    }
    if (this.mExtras != null) {
      paramJceOutputStream.write(this.mExtras, 7);
    }
    if (this.mUidKey != null) {
      paramJceOutputStream.write(this.mUidKey, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MGuide.MIntent
 * JD-Core Version:    0.7.0.1
 */