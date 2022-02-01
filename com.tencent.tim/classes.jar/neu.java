import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class neu
  extends lgv.b
{
  public neu(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, new Object[] { "handleDoFavoriteResult, isSuccess = ", Boolean.valueOf(paramBoolean), ", rowKey = ", paramString1, ", operationType = ", Integer.valueOf(paramInt), ", cid = ", paramString2 });
    if ((ReadInJoyFastWebBottomSocialView.a(this.this$0) == null) || (ReadInJoyFastWebBottomSocialView.a(this.this$0) == null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "handleDoFavoriteResult but articleInfo is null.");
      return;
    }
    QQToast localQQToast;
    if ((paramBoolean) && (ReadInJoyFastWebBottomSocialView.a(this.this$0).innerUniqueID.equals(paramString1)))
    {
      localQQToast = new QQToast(ReadInJoyFastWebBottomSocialView.a(this.this$0));
      localQQToast.setDuration(2000);
      localQQToast.setType(2);
      localQQToast.setToastIcon(QQToast.getIconRes(2));
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "handleDoFavoriteResult,operationType=" + paramInt + ",button status:" + ReadInJoyFastWebBottomSocialView.b(this.this$0).isSelected());
      if (paramInt != 1) {
        break label318;
      }
      ArrayList localArrayList = (ArrayList)ReadInJoyFastWebBottomSocialView.a(this.this$0).get(ReadInJoyFastWebBottomSocialView.a(this.this$0).innerUniqueID);
      paramString1 = localArrayList;
      if (localArrayList == null) {
        paramString1 = new ArrayList();
      }
      paramString1.add(paramString2);
      ReadInJoyFastWebBottomSocialView.a(this.this$0).put(ReadInJoyFastWebBottomSocialView.a(this.this$0).innerUniqueID, paramString1);
      if (!ReadInJoyFastWebBottomSocialView.b(this.this$0).isSelected()) {
        break label307;
      }
      localQQToast.setToastMsg("");
      ReadInJoyFastWebBottomSocialView.b(this.this$0, true);
      localQQToast.show();
    }
    for (;;)
    {
      ReadInJoyFastWebBottomSocialView.a(this.this$0, false);
      return;
      label307:
      ReadInJoyFastWebBottomSocialView.c(this.this$0, false);
      continue;
      label318:
      if (paramInt == 2)
      {
        ReadInJoyFastWebBottomSocialView.a(this.this$0).remove(ReadInJoyFastWebBottomSocialView.a(this.this$0).innerUniqueID);
        if (!ReadInJoyFastWebBottomSocialView.b(this.this$0).isSelected())
        {
          localQQToast.setToastMsg("");
          ReadInJoyFastWebBottomSocialView.b(this.this$0, false);
          localQQToast.show();
        }
        else
        {
          ReadInJoyFastWebBottomSocialView.c(this.this$0, true);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList<String> paramArrayList)
  {
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, "handleFavoriteStatus, isSuccess = " + paramBoolean1 + ", rowKey =  " + paramString + ", isFavorite = " + paramBoolean2 + ", cidList = " + paramArrayList);
    if ((paramBoolean1) && (ReadInJoyFastWebBottomSocialView.a(this.this$0).innerUniqueID.equals(paramString)))
    {
      ReadInJoyFastWebBottomSocialView.a(this.this$0).put(paramString, paramArrayList);
      ReadInJoyFastWebBottomSocialView.b(this.this$0, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     neu
 * JD-Core Version:    0.7.0.1
 */