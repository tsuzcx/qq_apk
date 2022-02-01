import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class wao
  extends wal
{
  public wao(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561663);
  }
  
  public void a()
  {
    this.a.setTag(2131374457, null);
  }
  
  public void a(vxd paramvxd)
  {
    super.a(paramvxd);
    this.a.setDisplayState(2);
    c(paramvxd.jdField_b_of_type_JavaLangString);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramvxd.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramvxd.c))
      {
        str = amtj.a(2131712377);
        localStoryMsgNodeFrameLayout.setNodeName(str, paramvxd.j);
        if ((paramvxd.jdField_a_of_type_JavaUtilList == null) || (paramvxd.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.a.a(1, 1 - paramvxd.jdField_b_of_type_Int);
        }
        str = (String)this.a.getTag(2131374457);
        if (!TextUtils.equals(paramvxd.jdField_a_of_type_JavaLangString, str)) {
          switch (paramvxd.jdField_a_of_type_Int)
          {
          default: 
            str = "unknown";
          }
        }
      }
    }
    for (;;)
    {
      xwa.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramvxd.jdField_a_of_type_JavaLangString, str });
      this.a.setTag(2131374457, paramvxd.jdField_a_of_type_JavaLangString);
      return;
      str = paramvxd.c;
      break;
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramvxd.c)) {}
      for (str = amtj.a(2131712384);; str = paramvxd.c)
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
 * Qualified Name:     wao
 * JD-Core Version:    0.7.0.1
 */