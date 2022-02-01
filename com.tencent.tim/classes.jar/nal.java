import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class nal
{
  private static final String TAG = nal.class.getSimpleName();
  private naf jdField_a_of_type_Naf;
  private naq.d jdField_a_of_type_Naq$d;
  private Activity mActivity;
  
  nal(Activity paramActivity, naf paramnaf, naq.d paramd)
  {
    this.mActivity = paramActivity;
    this.jdField_a_of_type_Naf = paramnaf;
    this.jdField_a_of_type_Naq$d = paramd;
  }
  
  public void P(VideoInfo paramVideoInfo)
  {
    boolean bool = true;
    if (kpn.nx() == 1) {}
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent(this.mActivity, ReadInJoyDeliverBiuActivity.class);
        if ((paramVideoInfo.busiType == 6) && (paramVideoInfo.articleInfo != null)) {
          localIntent.putExtra("feedsType", paramVideoInfo.articleInfo.mFeedType);
        }
        localIntent.putExtra("ARG_VIDEO_ARTICLE_ID", paramVideoInfo.Wz);
        localIntent.putExtra("biu_src", 2);
        localIntent.putExtra("arg_from_type", 8);
        localIntent.putExtra("arg_article_info", paramVideoInfo.articleInfo);
        localIntent.putExtra("fast_biu_type", bool);
        this.mActivity.startActivityForResult(localIntent, 102);
        this.mActivity.overridePendingTransition(0, 0);
        return;
      }
      catch (Exception paramVideoInfo)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, "innerOpenReadInJoyBiuActivity error exception = " + paramVideoInfo.getMessage());
      }
      bool = false;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    label20:
    String str;
    VideoInfo localVideoInfo;
    do
    {
      do
      {
        do
        {
          return;
          break label20;
          while (paramInt2 != -1) {}
          str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
        } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_Naf == null));
        paramIntent = this.jdField_a_of_type_Naq$d.bg().iterator();
      } while (!paramIntent.hasNext());
      localVideoInfo = (VideoInfo)paramIntent.next();
    } while (!str.equals(localVideoInfo.Wz));
    localVideoInfo.aHb += 1;
    this.jdField_a_of_type_Naf.i(localVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nal
 * JD-Core Version:    0.7.0.1
 */