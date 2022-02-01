import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView.b;
import com.tencent.qphone.base.util.QLog;

public class mat
{
  public static class a
    extends ClickableSpan
    implements ReadInJoyYAFolderTextView.b
  {
    private mas a;
    private int bgColor = -1;
    boolean mIsPressed;
    private TextPaint mPaint;
    protected long mUin;
    
    public a(long paramLong, int paramInt, mas parammas)
    {
      this.mUin = paramLong;
      this.bgColor = paramInt;
      this.a = parammas;
    }
    
    private void f(long paramLong, Context paramContext)
    {
      if ((this.a.a == null) || (this.a.a.a() == null) || (this.a.a.a().mSocialFeedInfo == null) || (this.a.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null)) {
        return;
      }
      Object localObject = kwt.acF + aqgo.encodeToString(String.valueOf(paramLong).getBytes(), 2);
      kxm.aJ(paramContext, (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("CommonBasicComponent", 2, "personal url =" + (String)localObject);
      }
      localObject = this.a.a.a();
      kxm.c = (ArticleInfo)localObject;
      String str = kxm.a("3", (ArticleInfo)localObject, paramLong);
      if (odv.aT(this.a.a.nh())) {}
      for (paramContext = "0X800935C";; paramContext = "0X8007BA3")
      {
        kbp.a(null, String.valueOf(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin), paramContext, paramContext, 0, 0, String.valueOf(this.a.a.a().mFeedId), "0", "" + ((ArticleInfo)localObject).mStrategyId, str, false);
        ndi.g((ArticleInfo)localObject, this.a.a.nh());
        return;
      }
    }
    
    public void onClick(View paramView)
    {
      if (paramView != null) {
        f(this.mUin, paramView.getContext());
      }
    }
    
    public void setPressed(boolean paramBoolean)
    {
      this.mIsPressed = paramBoolean;
      if (this.mPaint != null) {
        updateDrawState(this.mPaint);
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      this.mPaint = paramTextPaint;
      this.mPaint.setColor(Color.parseColor("#285c95"));
      paramTextPaint = this.mPaint;
      if (this.mIsPressed) {}
      for (int i = this.bgColor;; i = -1)
      {
        paramTextPaint.bgColor = i;
        this.mPaint.setUnderlineText(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mat
 * JD-Core Version:    0.7.0.1
 */