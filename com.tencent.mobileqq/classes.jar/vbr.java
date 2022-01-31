import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class vbr
  extends vbo
{
  public vbr(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561509);
  }
  
  public void a()
  {
    this.a.setTag(2131373850, null);
  }
  
  public void a(uyg paramuyg)
  {
    super.a(paramuyg);
    this.a.setDisplayState(2);
    c(paramuyg.jdField_b_of_type_JavaLangString);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramuyg.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramuyg.c))
      {
        str = alud.a(2131713657);
        localStoryMsgNodeFrameLayout.setNodeName(str, paramuyg.j);
        if ((paramuyg.jdField_a_of_type_JavaUtilList == null) || (paramuyg.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.a.a(1, 1 - paramuyg.jdField_b_of_type_Int);
        }
        str = (String)this.a.getTag(2131373850);
        if (!TextUtils.equals(paramuyg.jdField_a_of_type_JavaLangString, str)) {
          switch (paramuyg.jdField_a_of_type_Int)
          {
          default: 
            str = "unknown";
          }
        }
      }
    }
    for (;;)
    {
      wxj.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramuyg.jdField_a_of_type_JavaLangString, str });
      this.a.setTag(2131373850, paramuyg.jdField_a_of_type_JavaLangString);
      return;
      str = paramuyg.c;
      break;
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramuyg.c)) {}
      for (str = alud.a(2131713664);; str = paramuyg.c)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vbr
 * JD-Core Version:    0.7.0.1
 */