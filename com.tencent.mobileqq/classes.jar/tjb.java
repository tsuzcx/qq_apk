import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendActivityViewHolder.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class tjb
  extends tiy
{
  public static final void b(tfi paramtfi)
  {
    ThreadManager.post(new RecommendActivityViewHolder.1(paramtfi), 8, null, true);
  }
  
  public void a()
  {
    this.itemView.setTag(2131373348, null);
  }
  
  public void a(tfi paramtfi)
  {
    super.a(paramtfi);
    tsu.b(this.jdField_a_of_type_AndroidWidgetImageView, paramtfi.jdField_b_of_type_JavaLangString, true, (int)bbdh.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 50.0F));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    String str;
    int i;
    if (TextUtils.isEmpty(paramtfi.c))
    {
      str = ajyc.a(2131713263);
      localTextView.setText(str);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(0);
      if (paramtfi.jdField_b_of_type_Int <= 0) {
        break label247;
      }
      i = 1;
      label92:
      a(1, i);
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "FollowPersonViewHolder userItem = " + paramtfi.c + ", faceDrawable = " + paramtfi.jdField_b_of_type_JavaLangString);
      }
      str = (String)this.itemView.getTag(2131373348);
      if (!TextUtils.equals(paramtfi.jdField_a_of_type_JavaLangString, str)) {
        switch (paramtfi.jdField_a_of_type_Int)
        {
        default: 
          str = "unknown";
        }
      }
    }
    for (;;)
    {
      vel.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramtfi.jdField_a_of_type_JavaLangString, str });
      this.itemView.setTag(2131373348, paramtfi.jdField_a_of_type_JavaLangString);
      return;
      str = paramtfi.c;
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
 * Qualified Name:     tjb
 * JD-Core Version:    0.7.0.1
 */