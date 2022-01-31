import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class tiq
  extends tin
{
  public tiq(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561301);
  }
  
  public void a()
  {
    this.a.setTag(2131373350, null);
  }
  
  public void a(tff paramtff)
  {
    super.a(paramtff);
    this.a.setDisplayState(2);
    c(paramtff.jdField_b_of_type_JavaLangString);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramtff.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramtff.c))
      {
        str = ajya.a(2131713273);
        localStoryMsgNodeFrameLayout.setNodeName(str, paramtff.j);
        if ((paramtff.jdField_a_of_type_JavaUtilList == null) || (paramtff.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.a.a(1, 1 - paramtff.jdField_b_of_type_Int);
        }
        str = (String)this.a.getTag(2131373350);
        if (!TextUtils.equals(paramtff.jdField_a_of_type_JavaLangString, str)) {
          switch (paramtff.jdField_a_of_type_Int)
          {
          default: 
            str = "unknown";
          }
        }
      }
    }
    for (;;)
    {
      vei.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramtff.jdField_a_of_type_JavaLangString, str });
      this.a.setTag(2131373350, paramtff.jdField_a_of_type_JavaLangString);
      return;
      str = paramtff.c;
      break;
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramtff.c)) {}
      for (str = ajya.a(2131713280);; str = paramtff.c)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tiq
 * JD-Core Version:    0.7.0.1
 */