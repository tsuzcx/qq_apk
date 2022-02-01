package Protocol.MGuide;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
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
    Object localObject = this.mAction;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.mUri;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.mType;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.mPackage;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.mClass;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    int i = this.mFlags;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
    localObject = this.mCategories;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
    localObject = this.mExtras;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    localObject = this.mUidKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MGuide.MIntent
 * JD-Core Version:    0.7.0.1
 */