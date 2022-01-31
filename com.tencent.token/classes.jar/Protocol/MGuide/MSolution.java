package Protocol.MGuide;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class MSolution
  extends JceStruct
{
  static MIntent a = new MIntent();
  static Map b = new HashMap();
  static ArrayList c;
  static ArrayList d;
  static ArrayList e;
  static ArrayList f;
  static MDoraemonZip g = new MDoraemonZip();
  public ArrayList mBackupList = null;
  public int mHelpAnimation = 0;
  public ArrayList mHelpDoraemonResList = null;
  public MDoraemonZip mHelpDoraemonZip = null;
  public long mHelpDuration = 0L;
  public ArrayList mHelpImageList = null;
  public boolean mHelpImageLocal = true;
  public String mHelpInfo = "";
  public Map mHelpInfoAdapter = null;
  public int mHelpStyle = 0;
  public int mHelpTech = 0;
  public ArrayList mHelpTextList = null;
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
    if (this.mJumpIntent != null) {
      paramJceOutputStream.write(this.mJumpIntent, 0);
    }
    if (this.mHelpInfo != null) {
      paramJceOutputStream.write(this.mHelpInfo, 1);
    }
    if (this.mHelpDuration != 0L) {
      paramJceOutputStream.write(this.mHelpDuration, 2);
    }
    if (this.mHelpInfoAdapter != null) {
      paramJceOutputStream.write(this.mHelpInfoAdapter, 3);
    }
    if (this.mHelpStyle != 0) {
      paramJceOutputStream.write(this.mHelpStyle, 4);
    }
    if (this.mHelpImageList != null) {
      paramJceOutputStream.write(this.mHelpImageList, 5);
    }
    paramJceOutputStream.write(this.mHelpImageLocal, 6);
    if (this.mIntentCheck != 0) {
      paramJceOutputStream.write(this.mIntentCheck, 7);
    }
    if (this.mVersion != 0) {
      paramJceOutputStream.write(this.mVersion, 8);
    }
    if (this.mBackupList != null) {
      paramJceOutputStream.write(this.mBackupList, 9);
    }
    if (this.mHelpAnimation != 0) {
      paramJceOutputStream.write(this.mHelpAnimation, 10);
    }
    if (this.mHelpTech != 0) {
      paramJceOutputStream.write(this.mHelpTech, 11);
    }
    if (this.mHelpTextList != null) {
      paramJceOutputStream.write(this.mHelpTextList, 12);
    }
    paramJceOutputStream.write(this.mNoTrustAll, 13);
    if (this.mHelpDoraemonResList != null) {
      paramJceOutputStream.write(this.mHelpDoraemonResList, 14);
    }
    if (this.mHelpDoraemonZip != null) {
      paramJceOutputStream.write(this.mHelpDoraemonZip, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MGuide.MSolution
 * JD-Core Version:    0.7.0.1
 */