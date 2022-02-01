package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.a;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusBookData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData.a;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TitleData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lbz;
import lhu;
import nmt;
import nnr;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.Article;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleCommonInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleCover;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleExtInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspArticle;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspBody;

public class FastWebArticleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FastWebArticleInfo> CREATOR = new nmt();
  public RelatedSearchData a;
  public SparseArray<nnr> aA = new SparseArray();
  public String accountName;
  public String amf;
  public String amg;
  public String amh;
  public String ami;
  public String amj;
  public String amk;
  public String aml = "";
  public String amm;
  public String amn;
  public String articleContent;
  public String articleContentUrl;
  public String articleId;
  public String articleUrl;
  public boolean aty;
  public int bat;
  public String desc;
  private Map<String, JSONObject> eG = new HashMap();
  public int flag;
  public boolean isFavorite;
  public boolean isLiked;
  public List<ArticleTopicData.a> kn;
  private List<String> ko = new ArrayList();
  public int likeCnt;
  public long puin;
  public String rowKey;
  public long sN;
  public String shareWord;
  public String tags;
  public String title;
  public long xK;
  public long xL;
  
  /* Error */
  private byte[] q(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   5: lstore 4
    //   7: new 99	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 102	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: astore 7
    //   17: new 104	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: invokespecial 105	java/io/ByteArrayOutputStream:<init>	()V
    //   24: astore 6
    //   26: new 107	java/util/zip/GZIPInputStream
    //   29: dup
    //   30: aload 7
    //   32: invokespecial 110	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore 7
    //   37: sipush 1024
    //   40: newarray byte
    //   42: astore 8
    //   44: aload 7
    //   46: aload 8
    //   48: invokevirtual 114	java/util/zip/GZIPInputStream:read	([B)I
    //   51: istore_2
    //   52: iload_2
    //   53: iconst_m1
    //   54: if_icmpeq +170 -> 224
    //   57: aload 6
    //   59: aload 8
    //   61: iconst_0
    //   62: iload_2
    //   63: invokevirtual 118	java/io/ByteArrayOutputStream:write	([BII)V
    //   66: goto -22 -> 44
    //   69: astore 6
    //   71: aload 6
    //   73: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   76: iconst_0
    //   77: newarray byte
    //   79: astore 6
    //   81: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   84: lload 4
    //   86: lsub
    //   87: lstore 4
    //   89: new 73	java/util/HashMap
    //   92: dup
    //   93: invokespecial 74	java/util/HashMap:<init>	()V
    //   96: astore 7
    //   98: aload 7
    //   100: ldc 123
    //   102: invokestatic 129	kxm:getAccount	()Ljava/lang/String;
    //   105: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: aload 7
    //   111: ldc 135
    //   113: aload_0
    //   114: getfield 137	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo:rowKey	Ljava/lang/String;
    //   117: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: aload 7
    //   123: ldc 139
    //   125: new 141	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   132: lload 4
    //   134: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: ldc 78
    //   139: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: aload 7
    //   151: ldc 154
    //   153: ldc 156
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_1
    //   162: arraylength
    //   163: i2d
    //   164: ldc2_w 157
    //   167: dmul
    //   168: aload 6
    //   170: arraylength
    //   171: i2d
    //   172: ddiv
    //   173: invokestatic 164	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   176: aastore
    //   177: invokestatic 170	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   180: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: iload_3
    //   185: ifeq +66 -> 251
    //   188: iconst_1
    //   189: istore_2
    //   190: aload 7
    //   192: ldc 172
    //   194: iload_2
    //   195: invokestatic 175	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   198: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: invokestatic 181	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   205: invokestatic 186	anpc:a	(Landroid/content/Context;)Lanpc;
    //   208: aconst_null
    //   209: ldc 188
    //   211: iload_3
    //   212: lload 4
    //   214: lconst_0
    //   215: aload 7
    //   217: aconst_null
    //   218: invokevirtual 192	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   221: aload 6
    //   223: areturn
    //   224: aload 6
    //   226: invokevirtual 196	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   229: astore 6
    //   231: iconst_1
    //   232: istore_3
    //   233: goto -152 -> 81
    //   236: astore 6
    //   238: aload 6
    //   240: invokevirtual 197	java/lang/Throwable:printStackTrace	()V
    //   243: iconst_0
    //   244: newarray byte
    //   246: astore 6
    //   248: goto -167 -> 81
    //   251: iconst_0
    //   252: istore_2
    //   253: goto -63 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	FastWebArticleInfo
    //   0	256	1	paramArrayOfByte	byte[]
    //   51	202	2	i	int
    //   1	232	3	bool	boolean
    //   5	208	4	l	long
    //   24	34	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   69	3	6	localIOException	java.io.IOException
    //   79	151	6	arrayOfByte1	byte[]
    //   236	3	6	localThrowable	java.lang.Throwable
    //   246	1	6	arrayOfByte2	byte[]
    //   15	201	7	localObject	Object
    //   42	18	8	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   7	44	69	java/io/IOException
    //   44	52	69	java/io/IOException
    //   57	66	69	java/io/IOException
    //   224	231	69	java/io/IOException
    //   7	44	236	java/lang/Throwable
    //   44	52	236	java/lang/Throwable
    //   57	66	236	java/lang/Throwable
    //   224	231	236	java/lang/Throwable
  }
  
  public boolean FN()
  {
    return this.isFavorite;
  }
  
  public boolean FO()
  {
    return (this.flag & 0x1) == 0;
  }
  
  public boolean FP()
  {
    return (this.flag & 0x2) != 0;
  }
  
  public void I(long paramLong1, long paramLong2)
  {
    this.sN = paramLong1;
    this.xK = paramLong2;
  }
  
  public void I(ArticleInfo paramArticleInfo)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebArticleInfo.2(this, paramArticleInfo));
  }
  
  public AuthorData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    AuthorData localAuthorData = new AuthorData(paramArticleInfo, paramFastWebArticleInfo);
    if (FP())
    {
      localAuthorData.accountName = paramArticleInfo.mSubscribeName;
      localAuthorData.hH = paramArticleInfo.getSubscribeUin();
      localAuthorData.alY = "";
      if (TextUtils.isEmpty(localAuthorData.accountName))
      {
        if (!TextUtils.isEmpty(this.accountName)) {
          break label127;
        }
        paramFastWebArticleInfo = this.ami;
        localAuthorData.accountName = paramFastWebArticleInfo;
        paramArticleInfo.mSubscribeName = localAuthorData.accountName;
      }
    }
    for (;;)
    {
      localAuthorData.alZ = this.amg;
      localAuthorData.xI = this.xK;
      localAuthorData.atm = lbz.a().dI(paramArticleInfo.getSubscribeUin());
      localAuthorData.amd = this.amm;
      localAuthorData.mModuleType = 1;
      localAuthorData.kC = 1.0F;
      return localAuthorData;
      label127:
      paramFastWebArticleInfo = this.accountName;
      break;
      localAuthorData.accountName = this.accountName;
      localAuthorData.hH = paramArticleInfo.getSubscribeUin();
      localAuthorData.alY = this.amh;
      localAuthorData.authorName = this.ami;
    }
  }
  
  public TitleData a(ArticleInfo paramArticleInfo)
  {
    TitleData localTitleData = new TitleData();
    localTitleData.articleTitle = this.title;
    localTitleData.articleInfo = paramArticleInfo;
    localTitleData.amd = this.amm;
    localTitleData.mModuleType = 1;
    localTitleData.bad = 1;
    return localTitleData;
  }
  
  public boolean a(oidb_cmd0xad6.RspBody paramRspBody, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject = (oidb_cmd0xad6.Article)((oidb_cmd0xad6.RspArticle)paramRspBody.msg_rsp_article.get()).msg_article.get();
        oidb_cmd0xad6.ArticleCommonInfo localArticleCommonInfo = (oidb_cmd0xad6.ArticleCommonInfo)((oidb_cmd0xad6.Article)localObject).msg_article_common.get();
        this.title = localArticleCommonInfo.bytes_title.get().toStringUtf8();
        this.desc = localArticleCommonInfo.bytes_desc.get().toStringUtf8();
        this.accountName = localArticleCommonInfo.bytes_account_name.get().toStringUtf8();
        this.amh = localArticleCommonInfo.bytes_account_icon.get().toStringUtf8();
        this.ami = localArticleCommonInfo.bytes_account_author.get().toStringUtf8();
        this.amg = localArticleCommonInfo.bytes_date.get().toStringUtf8();
        this.shareWord = localArticleCommonInfo.bytes_share_words.get().toStringUtf8();
        this.rowKey = localArticleCommonInfo.bytes_row_key.get().toStringUtf8();
        this.flag = localArticleCommonInfo.uint32_article_flag.get();
        this.tags = localArticleCommonInfo.bytes_tags.get().toStringUtf8();
        this.articleId = localArticleCommonInfo.bytes_article_id.get().toStringUtf8();
        this.puin = localArticleCommonInfo.uint64_public_uin.get();
        this.amm = localArticleCommonInfo.bytes_proteus_json_data.get().toStringUtf8();
        if (localArticleCommonInfo.bytes_article_url.has()) {
          this.articleUrl = localArticleCommonInfo.bytes_article_url.get().toStringUtf8();
        }
        if ((localArticleCommonInfo.msg_cover.has()) && (((oidb_cmd0xad6.ArticleCover)localArticleCommonInfo.msg_cover.get()).bytes_cover_url.has())) {
          this.amn = ((oidb_cmd0xad6.ArticleCover)localArticleCommonInfo.msg_cover.get()).bytes_cover_url.get().toStringUtf8();
        }
        if (localArticleCommonInfo.bytes_original_url.has()) {
          this.articleContentUrl = localArticleCommonInfo.bytes_original_url.get().toStringUtf8();
        }
        paramRspBody = (oidb_cmd0xad6.ArticleExtInfo)paramRspBody.msg_ext_info.get();
        if (((oidb_cmd0xad6.Article)localObject).uint32_zip.get() == 1)
        {
          localObject = q(((oidb_cmd0xad6.Article)localObject).bytes_html.get().toByteArray());
          if (localObject.length > 0)
          {
            this.articleContent = new String((byte[])localObject, "UTF-8");
            this.xK = paramRspBody.uint64_read_count.get();
            this.sN = paramRspBody.uint64_comment.get();
            this.amf = paramRspBody.bytes_comment_url.get().toStringUtf8();
            if (paramInt == 3)
            {
              bool = true;
              this.aty = bool;
              this.isFavorite = false;
              return true;
            }
          }
          else
          {
            QLog.d(lhu.TAG, 1, "uncompress article content data error !");
            return false;
          }
        }
        else
        {
          this.articleContent = ((oidb_cmd0xad6.Article)localObject).bytes_html.get().toStringUtf8();
          continue;
        }
        boolean bool = false;
      }
      catch (Exception paramRspBody)
      {
        paramRspBody.printStackTrace();
        QLog.d("Q.readinjoy.fast_web", 2, "parse server resp value error : " + paramRspBody);
        return false;
      }
    }
  }
  
  public List<String> bj()
  {
    return this.ko;
  }
  
  public void da(List<BaseData> paramList)
  {
    if (paramList != null)
    {
      this.ko.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (BaseData)paramList.next();
        if (((BaseData)localObject).type == 18)
        {
          localObject = (ProteusBookData)localObject;
          if (((ProteusBookData)localObject).sourceId != null) {
            this.ko.add(((ProteusBookData)localObject).sourceId);
          }
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public JSONObject f(String paramString)
  {
    return (JSONObject)this.eG.get(paramString);
  }
  
  public void l(String paramString, JSONObject paramJSONObject)
  {
    this.eG.put(paramString, paramJSONObject);
  }
  
  public void pS(boolean paramBoolean)
  {
    this.isFavorite = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    localStringBuilder1.append("rowKey : ").append(this.rowKey).append("\n");
    localStringBuilder1.append("title : ").append(this.title).append("\n");
    localStringBuilder1.append("desc : ").append(this.desc).append("\n");
    localStringBuilder1.append("accountName : ").append(this.accountName).append("\n");
    localStringBuilder1.append("accoountAuthor : ").append(this.ami).append("\n");
    localStringBuilder1.append("publicTime : ").append(this.amg).append("\n");
    localStringBuilder1.append("accountIcon : ").append(this.amh).append("\n");
    localStringBuilder1.append("commentCnt : ").append(this.sN).append("\n");
    localStringBuilder1.append("commentUrl : ").append(this.amf).append("\n");
    localStringBuilder1.append("shareWord : ").append(this.shareWord).append("\n");
    localStringBuilder1.append("readCnt : ").append(this.xK).append("\n");
    localStringBuilder1.append("flag : ").append(this.flag).append("\n");
    localStringBuilder1.append("tags : ").append(this.tags).append("\n");
    localStringBuilder1.append("content : ").append(this.articleContent).append("\n");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("isFavorite : ");
    if (this.isFavorite) {}
    for (int i = 1;; i = 0)
    {
      localStringBuilder2.append(i).append("\n");
      localStringBuilder1.append("cashFlag : ").append(this.bat).append("\n");
      localStringBuilder1.append("cashInfo : ").append(this.aml).append("\n");
      localStringBuilder1.append("proteusJsonData : ").append(this.amm).append("\n");
      return localStringBuilder1.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.articleContent);
    paramParcel.writeLong(this.xK);
    paramParcel.writeLong(this.sN);
    paramParcel.writeString(this.amf);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.accountName);
    paramParcel.writeString(this.amg);
    paramParcel.writeString(this.ami);
    paramParcel.writeString(this.amh);
    paramParcel.writeString(this.rowKey);
    paramParcel.writeString(this.shareWord);
    paramParcel.writeInt(this.flag);
    paramParcel.writeString(this.tags);
    if (this.aty)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.articleId);
      paramParcel.writeLong(this.puin);
      if (!this.isFavorite) {
        break label254;
      }
    }
    Iterator localIterator;
    Object localObject;
    label254:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.amm);
      if (this.kn == null) {
        break label259;
      }
      paramParcel.writeInt(this.kn.size());
      localIterator = this.kn.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ArticleTopicData.a)localIterator.next();
        paramParcel.writeString(((ArticleTopicData.a)localObject).title);
        paramParcel.writeLong(((ArticleTopicData.a)localObject).vr);
        paramParcel.writeString(((ArticleTopicData.a)localObject).jumpUrl);
      }
      paramInt = 0;
      break;
    }
    label259:
    paramParcel.writeInt(0);
    if (this.a != null) {
      if ((this.a.kl != null) && (this.a.kl.size() > 0))
      {
        paramParcel.writeInt(this.a.kl.size());
        localIterator = this.a.kl.iterator();
        while (localIterator.hasNext())
        {
          localObject = (RelatedSearchData.a)localIterator.next();
          paramParcel.writeString(((RelatedSearchData.a)localObject).word);
          paramParcel.writeString(((RelatedSearchData.a)localObject).jumpUrl);
          paramParcel.writeFloat(((RelatedSearchData.a)localObject).score);
          paramParcel.writeString(((RelatedSearchData.a)localObject).modelName);
          paramParcel.writeInt(((RelatedSearchData.a)localObject).bah);
        }
        paramParcel.writeString(this.a.sid);
      }
    }
    for (;;)
    {
      paramParcel.writeInt(this.bat);
      paramParcel.writeString(this.aml);
      return;
      paramParcel.writeInt(0);
      continue;
      paramParcel.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo
 * JD-Core Version:    0.7.0.1
 */