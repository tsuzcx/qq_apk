package Protocol.MGuide;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class MSolution
  extends JceStruct
{
  static MIntent a = new MIntent();
  static Map<Integer, String> b = new HashMap();
  static ArrayList<String> c;
  static ArrayList<MSolution> d;
  static ArrayList<String> e;
  static ArrayList<MDoraemonRes> f;
  static MDoraemonZip g = new MDoraemonZip();
  public ArrayList<MSolution> mBackupList = null;
  public int mHelpAnimation = 0;
  public ArrayList<MDoraemonRes> mHelpDoraemonResList = null;
  public MDoraemonZip mHelpDoraemonZip = null;
  public long mHelpDuration = 0L;
  public ArrayList<String> mHelpImageList = null;
  public boolean mHelpImageLocal = true;
  public String mHelpInfo = "";
  public Map<Integer, String> mHelpInfoAdapter = null;
  public int mHelpStyle = 0;
  public int mHelpTech = 0;
  public ArrayList<String> mHelpTextList = null;
  public int mIntentCheck = 0;
  public MIntent mJumpIntent = null;
  public boolean mNoTrustAll = true;
  public int mVersion = 0;
  
  static
  {
    b.put(Integer.valueOf(0), "");
    c = new ArrayList();
    c.add("");
    d = new ArrayList();
    Object localObject = new MSolution();
    d.add(localObject);
    e = new ArrayList();
    e.add("");
    f = new ArrayList();
    localObject = new MDoraemonRes();
    f.add(localObject);
  }
  
  public JceStruct newInit()
  {
    return new MSolution();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mJumpIntent = ((MIntent)paramJceInputStream.read(a, 0, false));
    this.mHelpInfo = paramJceInputStream.readString(1, false);
    this.mHelpDuration = paramJceInputStream.read(this.mHelpDuration, 2, false);
    this.mHelpInfoAdapter = ((Map)paramJceInputStream.read(b, 3, false));
    this.mHelpStyle = paramJceInputStream.read(this.mHelpStyle, 4, false);
    this.mHelpImageList = ((ArrayList)paramJceInputStream.read(c, 5, false));
    this.mHelpImageLocal = paramJceInputStream.read(this.mHelpImageLocal, 6, false);
    this.mIntentCheck = paramJceInputStream.read(this.mIntentCheck, 7, false);
    this.mVersion = paramJceInputStream.read(this.mVersion, 8, false);
    this.mBackupList = ((ArrayList)paramJceInputStream.read(d, 9, false));
    this.mHelpAnimation = paramJceInputStream.read(this.mHelpAnimation, 10, false);
    this.mHelpTech = paramJceInputStream.read(this.mHelpTech, 11, false);
    this.mHelpTextList = ((ArrayList)paramJceInputStream.read(e, 12, false));
    this.mNoTrustAll = paramJceInputStream.read(this.mNoTrustAll, 13, false);
    this.mHelpDoraemonResList = ((ArrayList)paramJceInputStream.read(f, 14, false));
    this.mHelpDoraemonZip = ((MDoraemonZip)paramJceInputStream.read(g, 15, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.mJumpIntent;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.mHelpInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    long l = this.mHelpDuration;
    if (l != 0L) {
      paramJceOutputStream.write(l, 2);
    }
    localObject = this.mHelpInfoAdapter;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    int i = this.mHelpStyle;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
    localObject = this.mHelpImageList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
    paramJceOutputStream.write(this.mHelpImageLocal, 6);
    i = this.mIntentCheck;
    if (i != 0) {
      paramJceOutputStream.write(i, 7);
    }
    i = this.mVersion;
    if (i != 0) {
      paramJceOutputStream.write(i, 8);
    }
    localObject = this.mBackupList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
    i = this.mHelpAnimation;
    if (i != 0) {
      paramJceOutputStream.write(i, 10);
    }
    i = this.mHelpTech;
    if (i != 0) {
      paramJceOutputStream.write(i, 11);
    }
    localObject = this.mHelpTextList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 12);
    }
    paramJceOutputStream.write(this.mNoTrustAll, 13);
    localObject = this.mHelpDoraemonResList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 14);
    }
    localObject = this.mHelpDoraemonZip;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MGuide.MSolution
 * JD-Core Version:    0.7.0.1
 */