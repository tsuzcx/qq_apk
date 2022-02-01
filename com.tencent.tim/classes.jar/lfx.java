import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.guidingchannel.ReadInJoyChannelGuidingManager.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.InnerMsg;

public class lfx
{
  private static SparseArray<lfx.a> ac = new SparseArray();
  private static SparseArray<String> ad = new SparseArray();
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, ReadInJoyXListView paramReadInJoyXListView, ndi paramndi)
  {
    if ((paramBaseArticleInfo == null) || (paramReadInJoyXListView == null) || (paramndi == null))
    {
      QLog.e("ReadInJoyChannelGuidingManager", 1, "[openFirstInsertedArticle], articleInfo is null or listView is null, or adapter is null.");
      return;
    }
    int i = (int)paramBaseArticleInfo.mChannelID;
    String str = (String)ad.get(i);
    ad.remove(i);
    if (!TextUtils.equals(paramBaseArticleInfo.innerUniqueID, str))
    {
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[openFirstInsertedArticle], rowKey not equal, do not open; channelID = " + i + ", lastRowKey = " + str + ", innerUniqueID = " + paramBaseArticleInfo.innerUniqueID);
      return;
    }
    QLog.i("ReadInJoyChannelGuidingManager", 1, "[openFirstInsertedArticle], click first article.");
    kxm.p().post(new ReadInJoyChannelGuidingManager.1(paramReadInJoyXListView, paramndi));
  }
  
  public static void a(luq.b paramb, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    if ((paramb == null) || (paramList == null)) {
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], params is null or innerMsgList is null.");
    }
    int i;
    do
    {
      return;
      if (paramb.uH != -1L)
      {
        QLog.i("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], is not pull down refresh, do not insert.");
        return;
      }
      i = paramb.channelID;
    } while (!dH(i));
    paramb = (lfx.a)ac.get(i);
    oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
    localInnerMsg.uint32_jump_src_type.set(12);
    localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramb.rowKey)));
    if (i == 0) {
      localInnerMsg.uint32_jump_src_type.set(13);
    }
    try
    {
      localInnerMsg.uint64_algorithm_id.set(Long.valueOf(paramb.aeN).longValue());
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], insertArticle = " + paramb);
      paramList.add(0, localInnerMsg);
      qS(i);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], e = " + localNumberFormatException);
      }
    }
  }
  
  public static boolean dH(int paramInt)
  {
    lfx.a locala = (lfx.a)ac.get(paramInt);
    if (locala != null)
    {
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[isNeedToInsertArticle], " + locala);
      return locala.isValid();
    }
    QLog.i("ReadInJoyChannelGuidingManager", 1, "[isNeedToInsertArticle], channelID = " + paramInt + ", insertArticle is null.");
    return false;
  }
  
  public static void ng(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramString = Uri.parse(paramString);
      String str1 = paramString.getQueryParameter("channelid");
      Object localObject = paramString.getQueryParameter("algorithmid");
      String str2 = paramString.getQueryParameter("rowkey");
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], channelid = " + str1 + ", algorithmID = " + (String)localObject + ", rowKey = " + str2);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str2))) {
        continue;
      }
      localObject = new lfx.a((String)localObject, str2);
      try
      {
        int i = Integer.valueOf(str1).intValue();
        ac.put(i, localObject);
        ad.put(i, str2);
        try
        {
          str1 = paramString.getQueryParameter("article_url");
          paramString = paramString.getQueryParameter("show_floating_window");
          str2 = URLDecoder.decode(str1, "utf-8");
          if ((i == 0) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (TextUtils.equals("1", paramString)) && (awit.aMG()))
          {
            ad.remove(i);
            QLog.i("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], remove last rowKey.");
          }
          if ((i != 0) || (awit.aMG())) {
            continue;
          }
          ac.remove(i);
          ad.remove(i);
          QLog.i("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], remove insertInfo and last rowKey.");
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], e = " + paramString);
          return;
        }
        return;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], e = " + paramString);
      }
    }
  }
  
  private static void qS(int paramInt)
  {
    QLog.i("ReadInJoyChannelGuidingManager", 1, "[clearInsertedArticleInfo], channelID = " + paramInt);
    ac.remove(paramInt);
  }
  
  static class a
  {
    public String aeN;
    public String rowKey;
    
    a(String paramString1, String paramString2)
    {
      this.aeN = paramString1;
      this.rowKey = paramString2;
    }
    
    public boolean isValid()
    {
      return (!TextUtils.isEmpty(this.aeN)) && (!TextUtils.isEmpty(this.rowKey));
    }
    
    public String toString()
    {
      return "[insertArticleInfo] algorithmID = " + this.aeN + ", rowKey = " + this.rowKey;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfx
 * JD-Core Version:    0.7.0.1
 */