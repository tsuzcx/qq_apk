import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class wvd
  extends wva
{
  public wvd(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561744);
  }
  
  public void a()
  {
    this.a.setTag(2131374552, null);
  }
  
  public void a(wrs paramwrs)
  {
    super.a(paramwrs);
    this.a.setDisplayState(2);
    c(paramwrs.jdField_b_of_type_JavaLangString);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramwrs.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramwrs.c))
      {
        str = anni.a(2131712036);
        localStoryMsgNodeFrameLayout.setNodeName(str, paramwrs.j);
        if ((paramwrs.jdField_a_of_type_JavaUtilList == null) || (paramwrs.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.a.a(1, 1 - paramwrs.jdField_b_of_type_Int);
        }
        str = (String)this.a.getTag(2131374552);
        if (!TextUtils.equals(paramwrs.jdField_a_of_type_JavaLangString, str)) {
          switch (paramwrs.jdField_a_of_type_Int)
          {
          default: 
            str = "unknown";
          }
        }
      }
    }
    for (;;)
    {
      yqu.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramwrs.jdField_a_of_type_JavaLangString, str });
      this.a.setTag(2131374552, paramwrs.jdField_a_of_type_JavaLangString);
      return;
      str = paramwrs.c;
      break;
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramwrs.c)) {}
      for (str = anni.a(2131712043);; str = paramwrs.c)
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
 * Qualified Name:     wvd
 * JD-Core Version:    0.7.0.1
 */