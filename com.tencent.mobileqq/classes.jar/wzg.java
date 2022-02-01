import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendActivityViewHolder.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class wzg
  extends wzd
{
  public static final void b(wvn paramwvn)
  {
    ThreadManager.post(new RecommendActivityViewHolder.1(paramwvn), 8, null, true);
  }
  
  public void a()
  {
    this.itemView.setTag(2131374689, null);
  }
  
  public void a(wvn paramwvn)
  {
    super.a(paramwvn);
    xiz.b(this.jdField_a_of_type_AndroidWidgetImageView, paramwvn.jdField_b_of_type_JavaLangString, true, (int)bhmg.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 50.0F));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    String str;
    int i;
    if (TextUtils.isEmpty(paramwvn.c))
    {
      str = anzj.a(2131712146);
      localTextView.setText(str);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(0);
      if (paramwvn.jdField_b_of_type_Int <= 0) {
        break label247;
      }
      i = 1;
      label92:
      a(1, i);
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "FollowPersonViewHolder userItem = " + paramwvn.c + ", faceDrawable = " + paramwvn.jdField_b_of_type_JavaLangString);
      }
      str = (String)this.itemView.getTag(2131374689);
      if (!TextUtils.equals(paramwvn.jdField_a_of_type_JavaLangString, str)) {
        switch (paramwvn.jdField_a_of_type_Int)
        {
        default: 
          str = "unknown";
        }
      }
    }
    for (;;)
    {
      yup.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramwvn.jdField_a_of_type_JavaLangString, str });
      this.itemView.setTag(2131374689, paramwvn.jdField_a_of_type_JavaLangString);
      return;
      str = paramwvn.c;
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
 * Qualified Name:     wzg
 * JD-Core Version:    0.7.0.1
 */