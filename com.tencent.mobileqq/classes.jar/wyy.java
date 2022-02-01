import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class wyy
  extends wyv
{
  public wyy(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561785);
  }
  
  public void a()
  {
    this.a.setTag(2131374689, null);
  }
  
  public void a(wvn paramwvn)
  {
    super.a(paramwvn);
    this.a.setDisplayState(2);
    c(paramwvn.jdField_b_of_type_JavaLangString);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramwvn.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramwvn.c))
      {
        str = anzj.a(2131712145);
        localStoryMsgNodeFrameLayout.setNodeName(str, paramwvn.j);
        if ((paramwvn.jdField_a_of_type_JavaUtilList == null) || (paramwvn.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.a.a(1, 1 - paramwvn.jdField_b_of_type_Int);
        }
        str = (String)this.a.getTag(2131374689);
        if (!TextUtils.equals(paramwvn.jdField_a_of_type_JavaLangString, str)) {
          switch (paramwvn.jdField_a_of_type_Int)
          {
          default: 
            str = "unknown";
          }
        }
      }
    }
    for (;;)
    {
      yup.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramwvn.jdField_a_of_type_JavaLangString, str });
      this.a.setTag(2131374689, paramwvn.jdField_a_of_type_JavaLangString);
      return;
      str = paramwvn.c;
      break;
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramwvn.c)) {}
      for (str = anzj.a(2131712152);; str = paramwvn.c)
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
 * Qualified Name:     wyy
 * JD-Core Version:    0.7.0.1
 */