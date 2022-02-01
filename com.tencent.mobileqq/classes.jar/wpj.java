import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class wpj
  extends wpg
{
  public wpj(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561731);
  }
  
  public void a()
  {
    this.a.setTag(2131374695, null);
  }
  
  public void a(wly paramwly)
  {
    super.a(paramwly);
    this.a.setDisplayState(2);
    c(paramwly.jdField_b_of_type_JavaLangString);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramwly.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramwly.c))
      {
        str = anvx.a(2131712724);
        localStoryMsgNodeFrameLayout.setNodeName(str, paramwly.j);
        if ((paramwly.jdField_a_of_type_JavaUtilList == null) || (paramwly.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.a.a(1, 1 - paramwly.jdField_b_of_type_Int);
        }
        str = (String)this.a.getTag(2131374695);
        if (!TextUtils.equals(paramwly.jdField_a_of_type_JavaLangString, str)) {
          switch (paramwly.jdField_a_of_type_Int)
          {
          default: 
            str = "unknown";
          }
        }
      }
    }
    for (;;)
    {
      ykv.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramwly.jdField_a_of_type_JavaLangString, str });
      this.a.setTag(2131374695, paramwly.jdField_a_of_type_JavaLangString);
      return;
      str = paramwly.c;
      break;
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramwly.c)) {}
      for (str = anvx.a(2131712731);; str = paramwly.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, false);
        break;
      }
      str = "2";
      continue;
      str = "3";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpj
 * JD-Core Version:    0.7.0.1
 */