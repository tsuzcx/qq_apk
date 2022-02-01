import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.Iterator;
import java.util.List;

public class pwt
  extends pwl
{
  public pwt(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected void a(String paramString, boolean paramBoolean, puh parampuh)
  {
    if ((!TextUtils.isEmpty(parampuh.recommandNameIconUrl)) && (!paramBoolean))
    {
      this.a.setNodeName(paramString, parampuh.recommandNameIconUrl);
      return;
    }
    super.a(paramString, paramBoolean, parampuh);
  }
  
  public void bey()
  {
    this.a.setTag(2131375232, null);
  }
  
  protected String c(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.c(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = acfp.m(2131713757);
    }
    return paramQQUserUIItem;
  }
  
  public void r(puh parampuh)
  {
    super.r(parampuh);
    this.a.setDisplayState(2);
    String str;
    if (!TextUtils.equals((String)this.a.getTag(2131375232), parampuh.unionId))
    {
      if ((parampuh.iO == null) || (parampuh.iO.size() <= 0)) {
        break label168;
      }
      str = ((pux)parampuh.iO.get(0)).vid;
      Iterator localIterator = parampuh.iO.iterator();
      while (localIterator.hasNext())
      {
        pux localpux = (pux)localIterator.next();
        if (!localpux.aBR) {
          str = localpux.vid;
        }
      }
    }
    for (;;)
    {
      rar.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { parampuh.unionId, "1", "", str });
      this.a.setTag(2131375232, parampuh.unionId);
      return;
      continue;
      label168:
      str = "";
    }
  }
  
  protected void setCoverUrl(String paramString)
  {
    ru(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwt
 * JD-Core Version:    0.7.0.1
 */