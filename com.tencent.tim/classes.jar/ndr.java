import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.a;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ndr
  implements VideoPreDownloadMgr.a
{
  private int aYf = 10;
  
  ndr(ndi paramndi) {}
  
  public boolean Eb()
  {
    if (this.this$0.k != null) {}
    for (String str = this.this$0.k.getInnerUniqueID();; str = "") {
      return naa.a().b(this.this$0.a.b(str));
    }
  }
  
  public List<VideoPreDownloadMgr.b> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    int m;
    int k;
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.this$0.getCount()))
    {
      if ((this.this$0.mChannelID == 0) || (this.this$0.mChannelID == 40677)) {}
      int n;
      for (i = 0;; i = 1)
      {
        m = naa.a().t("video_channel", paramInt);
        k = i + paramInt;
        i = 0;
        for (;;)
        {
          j = i;
          if (k >= this.this$0.getCount()) {
            break label328;
          }
          j = i;
          if (k >= this.aYf + paramInt) {
            break label328;
          }
          n = this.this$0.dA(k);
          if ((n != 4) && (n != 6) && (n != 66) && (n != 115) && (n != 46))
          {
            j = i;
            if (n != 70) {
              break label890;
            }
          }
          localObject = this.this$0.c(k);
          if (localObject != null) {
            break;
          }
          k += 1;
        }
      }
      if ((n == 46) || (n == 70))
      {
        localArrayList.add(new VideoPreDownloadMgr.b(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
        localArrayList.add(new VideoPreDownloadMgr.b(((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).busiType, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).getVideoDuration()));
        i += 2;
        j = i;
        if (i < m) {
          break label890;
        }
      }
    }
    for (int j = i;; j = 0)
    {
      label328:
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "scroll to next = " + paramBoolean + " preDownload to forward = " + j);
      }
      j = 0;
      i = 0;
      if (paramInt >= 0)
      {
        m = naa.a().qj();
        k = paramInt - 1;
        label391:
        j = i;
        if (k > 0)
        {
          j = i;
          if (k > paramInt - this.aYf)
          {
            j = i;
            if (k < this.this$0.getCount())
            {
              j = this.this$0.dA(k);
              if ((j != 4) && (j != 6) && (j != 66) && (j != 115) && (j != 46) && (j != 70)) {
                break label887;
              }
              localObject = this.this$0.c(k);
              if (localObject != null) {}
            }
          }
        }
      }
      label887:
      for (;;)
      {
        k -= 1;
        break label391;
        localArrayList.add(new VideoPreDownloadMgr.b(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
        j = i + 1;
        i = j;
        if (((BaseArticleInfo)localObject).busiType != 5) {
          break;
        }
        i = j;
        if (!(localObject instanceof AdvertisementInfo)) {
          break;
        }
        i = j;
        if (((AdvertisementInfo)localObject).mImaxShowAdType != 1001) {
          break;
        }
        String str = ((AdvertisementInfo)localObject).mImaxVideoUrl;
        i = j;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        localObject = new VideoPreDownloadMgr.b(str, "", ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration());
        ((VideoPreDownloadMgr.b)localObject).aqv = true;
        localArrayList.add(localObject);
        i = j + 1;
        break;
        if ((j == 46) || (j == 70))
        {
          localArrayList.add(new VideoPreDownloadMgr.b(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
          localArrayList.add(new VideoPreDownloadMgr.b(((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).busiType, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).getVideoDuration()));
        }
        for (j = i + 2;; j = i + 1)
        {
          i = j;
          if (j < m) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "scroll to next = " + paramBoolean + " preDownload to backward = " + j);
          }
          return localArrayList;
          localArrayList.add(new VideoPreDownloadMgr.b(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
        }
      }
      label890:
      i = j;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ndr
 * JD-Core Version:    0.7.0.1
 */