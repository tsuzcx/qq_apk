import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class uxi
  extends uxf
{
  public uxi(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561491);
  }
  
  public void a()
  {
    this.a.setTag(2131373799, null);
  }
  
  public void a(utx paramutx)
  {
    super.a(paramutx);
    this.a.setDisplayState(2);
    c(paramutx.jdField_b_of_type_JavaLangString);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramutx.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramutx.c))
      {
        str = alpo.a(2131713645);
        localStoryMsgNodeFrameLayout.setNodeName(str, paramutx.j);
        if ((paramutx.jdField_a_of_type_JavaUtilList == null) || (paramutx.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.a.a(1, 1 - paramutx.jdField_b_of_type_Int);
        }
        str = (String)this.a.getTag(2131373799);
        if (!TextUtils.equals(paramutx.jdField_a_of_type_JavaLangString, str)) {
          switch (paramutx.jdField_a_of_type_Int)
          {
          default: 
            str = "unknown";
          }
        }
      }
    }
    for (;;)
    {
      wta.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramutx.jdField_a_of_type_JavaLangString, str });
      this.a.setTag(2131373799, paramutx.jdField_a_of_type_JavaLangString);
      return;
      str = paramutx.c;
      break;
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramutx.c)) {}
      for (str = alpo.a(2131713652);; str = paramutx.c)
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
 * Qualified Name:     uxi
 * JD-Core Version:    0.7.0.1
 */