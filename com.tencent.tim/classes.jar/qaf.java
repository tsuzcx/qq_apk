import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetEmoticonPackList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.EmoticonPack;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class qaf
  extends ppu
{
  public final String avr;
  public final byte[] bD;
  public final boolean mIsEnd;
  public final long mTimeStamp;
  public final List<qaf.a> nA;
  
  public qaf(qqstory_service.RspGetEmoticonPackList paramRspGetEmoticonPackList, byte[] paramArrayOfByte, long paramLong)
  {
    super(paramRspGetEmoticonPackList.result);
    boolean bool;
    ArrayList localArrayList;
    if (paramRspGetEmoticonPackList.is_end.get() != 0)
    {
      bool = true;
      this.mIsEnd = bool;
      this.avr = paramRspGetEmoticonPackList.next_cookie.get().toStringUtf8();
      localArrayList = new ArrayList();
      paramRspGetEmoticonPackList = paramRspGetEmoticonPackList.pack_list.get();
      if (paramRspGetEmoticonPackList != null) {
        paramRspGetEmoticonPackList = paramRspGetEmoticonPackList.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramRspGetEmoticonPackList.hasNext()) {
          break label151;
        }
        qaf.a locala = new qaf.a((qqstory_struct.EmoticonPack)paramRspGetEmoticonPackList.next());
        if (locala.isValid())
        {
          localArrayList.add(locala);
          continue;
          bool = false;
          break;
        }
        ram.w("GetEmojiPackInfoListResponse", "found invalid data we ignore it : " + locala);
      }
    }
    label151:
    this.nA = Collections.unmodifiableList(localArrayList);
    this.mTimeStamp = paramLong;
    this.bD = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.bD, 0, paramArrayOfByte.length);
  }
  
  public String toString()
  {
    return "GetEmojiPackInfoListResponse{mEmojiPackList.size=" + this.nA.size() + ", mIsEnd=" + this.mIsEnd + ", mNextCookie='" + this.avr + '\'' + '}';
  }
  
  public static class a
    implements Cloneable
  {
    public final String awr;
    public final String aws;
    public final String awt;
    public final String awu;
    public final String awv;
    public final String aww;
    public final String awx;
    public final int blE;
    public final int mType;
    
    public a(qqstory_struct.EmoticonPack paramEmoticonPack)
    {
      this.awr = String.valueOf(paramEmoticonPack.pack_id.get());
      this.aws = paramEmoticonPack.icon.get().toStringUtf8();
      this.awu = paramEmoticonPack.name.get().toStringUtf8();
      this.awv = paramEmoticonPack.download_url.get().toStringUtf8();
      this.aww = paramEmoticonPack.md5.get().toStringUtf8();
      this.blE = paramEmoticonPack.version.get();
      this.mType = dP(paramEmoticonPack.type.get());
      this.awt = paramEmoticonPack.download_icon.get().toStringUtf8();
      this.awx = paramEmoticonPack.config.get().toStringUtf8();
    }
    
    private int dP(int paramInt)
    {
      int i = paramInt;
      switch (paramInt)
      {
      default: 
        i = 1;
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.awr == null) {
          break;
        }
      } while (this.awr.equals(paramObject.awr));
      while (paramObject.awr != null) {
        return false;
      }
      return true;
    }
    
    public int hashCode()
    {
      if (this.awr != null) {
        return this.awr.hashCode();
      }
      return 0;
    }
    
    public boolean isValid()
    {
      if (this.mType == 1) {
        if ((TextUtils.isEmpty(this.aws)) || (TextUtils.isEmpty(this.awu)) || (TextUtils.isEmpty(this.awv)) || (TextUtils.isEmpty(this.aww))) {}
      }
      while ((!TextUtils.isEmpty(this.aws)) && (!TextUtils.isEmpty(this.awu)))
      {
        return true;
        return false;
      }
      return false;
    }
    
    public String toString()
    {
      return "EmojiPack{mPackId=" + this.awr + ", mLogoUrl='" + this.aws + '\'' + ", mPackName='" + this.awu + '\'' + ", mPackDownloadUrl='" + this.awv + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qaf
 * JD-Core Version:    0.7.0.1
 */