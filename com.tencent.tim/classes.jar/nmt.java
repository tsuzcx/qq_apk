import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.a;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData.a;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import java.util.ArrayList;
import java.util.List;

public final class nmt
  implements Parcelable.Creator<FastWebArticleInfo>
{
  public FastWebArticleInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    int j = 0;
    FastWebArticleInfo localFastWebArticleInfo = new FastWebArticleInfo();
    localFastWebArticleInfo.articleContent = paramParcel.readString();
    localFastWebArticleInfo.xK = paramParcel.readLong();
    localFastWebArticleInfo.sN = paramParcel.readLong();
    localFastWebArticleInfo.amf = paramParcel.readString();
    localFastWebArticleInfo.title = paramParcel.readString();
    localFastWebArticleInfo.desc = paramParcel.readString();
    localFastWebArticleInfo.accountName = paramParcel.readString();
    localFastWebArticleInfo.amg = paramParcel.readString();
    localFastWebArticleInfo.ami = paramParcel.readString();
    localFastWebArticleInfo.amh = paramParcel.readString();
    localFastWebArticleInfo.rowKey = paramParcel.readString();
    localFastWebArticleInfo.shareWord = paramParcel.readString();
    localFastWebArticleInfo.flag = paramParcel.readInt();
    localFastWebArticleInfo.tags = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localFastWebArticleInfo.aty = bool1;
      localFastWebArticleInfo.articleId = paramParcel.readString();
      localFastWebArticleInfo.puin = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label291;
      }
    }
    int k;
    Object localObject;
    int i;
    label291:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localFastWebArticleInfo.isFavorite = bool1;
      localFastWebArticleInfo.amm = paramParcel.readString();
      k = paramParcel.readInt();
      if (k < 0) {
        break label413;
      }
      localObject = new ArrayList();
      i = 0;
      while (i < k)
      {
        ArticleTopicData.a locala = new ArticleTopicData.a();
        locala.title = paramParcel.readString();
        locala.vr = paramParcel.readLong();
        locala.jumpUrl = paramParcel.readString();
        ((List)localObject).add(locala);
        i += 1;
      }
      bool1 = false;
      break;
    }
    label413:
    for (localFastWebArticleInfo.kn = ((List)localObject);; localFastWebArticleInfo.kn = null)
    {
      k = paramParcel.readInt();
      if (k <= 0) {
        break label455;
      }
      localFastWebArticleInfo.a = new RelatedSearchData(localFastWebArticleInfo);
      localFastWebArticleInfo.a.kl = new ArrayList();
      i = j;
      while (i < k)
      {
        localObject = new RelatedSearchData.a();
        ((RelatedSearchData.a)localObject).word = paramParcel.readString();
        ((RelatedSearchData.a)localObject).jumpUrl = paramParcel.readString();
        ((RelatedSearchData.a)localObject).score = paramParcel.readFloat();
        ((RelatedSearchData.a)localObject).modelName = paramParcel.readString();
        ((RelatedSearchData.a)localObject).bah = paramParcel.readInt();
        i += 1;
      }
    }
    localFastWebArticleInfo.a.sid = paramParcel.readString();
    for (;;)
    {
      localFastWebArticleInfo.bat = paramParcel.readInt();
      localFastWebArticleInfo.aml = paramParcel.readString();
      return localFastWebArticleInfo;
      label455:
      localFastWebArticleInfo.a = null;
    }
  }
  
  public FastWebArticleInfo[] a(int paramInt)
  {
    return new FastWebArticleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmt
 * JD-Core Version:    0.7.0.1
 */