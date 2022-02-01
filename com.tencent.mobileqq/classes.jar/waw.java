import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendActivityViewHolder.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class waw
  extends wat
{
  public static final void b(vxd paramvxd)
  {
    ThreadManager.post(new RecommendActivityViewHolder.1(paramvxd), 8, null, true);
  }
  
  public void a()
  {
    this.itemView.setTag(2131374457, null);
  }
  
  public void a(vxd paramvxd)
  {
    super.a(paramvxd);
    wkp.b(this.jdField_a_of_type_AndroidWidgetImageView, paramvxd.jdField_b_of_type_JavaLangString, true, (int)bfvh.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 50.0F));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    String str;
    int i;
    if (TextUtils.isEmpty(paramvxd.c))
    {
      str = amtj.a(2131712378);
      localTextView.setText(str);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(0);
      if (paramvxd.jdField_b_of_type_Int <= 0) {
        break label247;
      }
      i = 1;
      label92:
      a(1, i);
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "FollowPersonViewHolder userItem = " + paramvxd.c + ", faceDrawable = " + paramvxd.jdField_b_of_type_JavaLangString);
      }
      str = (String)this.itemView.getTag(2131374457);
      if (!TextUtils.equals(paramvxd.jdField_a_of_type_JavaLangString, str)) {
        switch (paramvxd.jdField_a_of_type_Int)
        {
        default: 
          str = "unknown";
        }
      }
    }
    for (;;)
    {
      xwa.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramvxd.jdField_a_of_type_JavaLangString, str });
      this.itemView.setTag(2131374457, paramvxd.jdField_a_of_type_JavaLangString);
      return;
      str = paramvxd.c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     waw
 * JD-Core Version:    0.7.0.1
 */