import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class nfa
  extends lgv.b
{
  public nfa(ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, new Object[] { "handleDoFavoriteResult, isSuccess = ", Boolean.valueOf(paramBoolean), ", rowKey = ", paramString1, ", operationType = ", Integer.valueOf(paramInt), ", cid = ", paramString2 });
    if ((ReadInJoyFastWebBottomSocialViewNew.a(this.this$0) == null) || (ReadInJoyFastWebBottomSocialViewNew.a(this.this$0) == null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "handleDoFavoriteResult but articleInfo is null.");
      return;
    }
    QQToast localQQToast;
    if ((paramBoolean) && (ReadInJoyFastWebBottomSocialViewNew.a(this.this$0).innerUniqueID.equals(paramString1)))
    {
      localQQToast = new QQToast(ReadInJoyFastWebBottomSocialViewNew.a(this.this$0));
      localQQToast.setDuration(2000);
      localQQToast.setType(2);
      localQQToast.setToastIcon(QQToast.getIconRes(2));
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "handleDoFavoriteResult,operationType=" + paramInt + ",button status:" + ReadInJoyFastWebBottomSocialViewNew.a(this.this$0));
      if (paramInt != 1) {
        break label293;
      }
      ArrayList localArrayList = (ArrayList)ReadInJoyFastWebBottomSocialViewNew.a(this.this$0).get(ReadInJoyFastWebBottomSocialViewNew.a(this.this$0).innerUniqueID);
      paramString1 = localArrayList;
      if (localArrayList == null) {
        paramString1 = new ArrayList();
      }
      paramString1.add(paramString2);
      ReadInJoyFastWebBottomSocialViewNew.a(this.this$0).put(ReadInJoyFastWebBottomSocialViewNew.a(this.this$0).innerUniqueID, paramString1);
      if (ReadInJoyFastWebBottomSocialViewNew.a(this.this$0))
      {
        localQQToast.setToastMsg("");
        localQQToast.show();
      }
    }
    for (;;)
    {
      ReadInJoyFastWebBottomSocialViewNew.a(this.this$0, false);
      return;
      label293:
      if (paramInt == 2)
      {
        ReadInJoyFastWebBottomSocialViewNew.a(this.this$0).remove(ReadInJoyFastWebBottomSocialViewNew.a(this.this$0).innerUniqueID);
        if (!ReadInJoyFastWebBottomSocialViewNew.a(this.this$0))
        {
          localQQToast.setToastMsg("");
          localQQToast.show();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList<String> paramArrayList)
  {
    QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "handleFavoriteStatus, isSuccess = " + paramBoolean1 + ", rowKey =  " + paramString + ", isFavorite = " + paramBoolean2 + ", cidList = " + paramArrayList);
    if ((paramBoolean1) && (ReadInJoyFastWebBottomSocialViewNew.a(this.this$0).innerUniqueID.equals(paramString))) {
      ReadInJoyFastWebBottomSocialViewNew.a(this.this$0).put(paramString, paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nfa
 * JD-Core Version:    0.7.0.1
 */