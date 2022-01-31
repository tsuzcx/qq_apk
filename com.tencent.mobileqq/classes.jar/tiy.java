import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendActivityViewHolder.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class tiy
  extends tiv
{
  public static final void b(tff paramtff)
  {
    ThreadManager.post(new RecommendActivityViewHolder.1(paramtff), 8, null, true);
  }
  
  public void a()
  {
    this.itemView.setTag(2131373350, null);
  }
  
  public void a(tff paramtff)
  {
    super.a(paramtff);
    tsr.b(this.jdField_a_of_type_AndroidWidgetImageView, paramtff.jdField_b_of_type_JavaLangString, true, (int)bbdv.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 50.0F));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    String str;
    int i;
    if (TextUtils.isEmpty(paramtff.c))
    {
      str = ajya.a(2131713274);
      localTextView.setText(str);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(0);
      if (paramtff.jdField_b_of_type_Int <= 0) {
        break label247;
      }
      i = 1;
      label92:
      a(1, i);
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "FollowPersonViewHolder userItem = " + paramtff.c + ", faceDrawable = " + paramtff.jdField_b_of_type_JavaLangString);
      }
      str = (String)this.itemView.getTag(2131373350);
      if (!TextUtils.equals(paramtff.jdField_a_of_type_JavaLangString, str)) {
        switch (paramtff.jdField_a_of_type_Int)
        {
        default: 
          str = "unknown";
        }
      }
    }
    for (;;)
    {
      vei.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramtff.jdField_a_of_type_JavaLangString, str });
      this.itemView.setTag(2131373350, paramtff.jdField_a_of_type_JavaLangString);
      return;
      str = paramtff.c;
      break;
      label247:
      i = 0;
      break label92;
      str = "2";
      continue;
      str = "3";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tiy
 * JD-Core Version:    0.7.0.1
 */