import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class akhy
  implements ausj.a
{
  akhy(akhv paramakhv, akhv.a parama, akjj paramakjj, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ajxs localajxs = new ajxs().h("data_card").i("feed_inform").d("2").a(this.jdField_a_of_type_Akhv.a(this.b)).b(this.jdField_a_of_type_Akjj.feedId).c(String.valueOf(this.jdField_a_of_type_Akhv.a(this.b)));
    if (this.jdField_a_of_type_Akhv.xv)
    {
      paramView = "1";
      localajxs.e(paramView).report(this.jdField_a_of_type_Akhv.mApp);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Akjj.uin)) || (!(this.jdField_a_of_type_Akhv.mContext instanceof BaseActivity))) {
        break label341;
      }
      paramView = new aqep.a();
      if (!(this.jdField_a_of_type_Akjj instanceof akjg)) {
        break label231;
      }
      paramView.b(((akjg)this.jdField_a_of_type_Akjj).faceUrl);
      label172:
      paramView.a(this.jdField_a_of_type_Akjj.agQ);
      paramView = paramView.s();
      aqep.b((BaseActivity)this.jdField_a_of_type_Akhv.mContext, 0L, this.jdField_a_of_type_Akjj.uin, null, 20006, "", paramView);
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      paramView = "2";
      break;
      label231:
      if ((this.jdField_a_of_type_Akjj instanceof akji))
      {
        paramView.d(((akji)this.jdField_a_of_type_Akjj).videoUrl).b(((akji)this.jdField_a_of_type_Akjj).faceUrl);
        break label172;
      }
      if ((this.jdField_a_of_type_Akjj instanceof akjk))
      {
        paramView.b(((akjk)this.jdField_a_of_type_Akjj).picUrl);
        break label172;
      }
      if ((this.jdField_a_of_type_Akjj instanceof akjm))
      {
        paramView.b(((akjm)this.jdField_a_of_type_Akjj).faceUrl);
        break label172;
      }
      if (!(this.jdField_a_of_type_Akjj instanceof akjn)) {
        break label172;
      }
      break label172;
      label341:
      QQToast.a(this.jdField_a_of_type_Akhv.mContext, 2, acfp.m(2131703135), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhy
 * JD-Core Version:    0.7.0.1
 */