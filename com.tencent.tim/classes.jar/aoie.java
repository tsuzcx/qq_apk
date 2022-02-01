import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class aoie
{
  static int[] COLORS;
  static int dOA = 2131701817;
  static int[] jf;
  static int[] ov = { 1001, 1002, 1003, 1004 };
  static int[] ow;
  static int[] ox;
  public ArrayList<String> Bj;
  public int bgColor;
  public boolean cLF;
  public int dOB;
  public int dOC;
  public int id;
  public String imgUrl;
  public int order;
  public String subTitle;
  public String title;
  
  static
  {
    COLORS = new int[] { -8293377, -42646, -35897, -16725252 };
    ow = new int[] { 2131695320, 2131721820, 2131720346, 2131701814 };
    jf = new int[] { 2130847062, 2130847065, 2130847064, 2130847063 };
    ox = new int[] { 2131701813, 2131701822, 2131701816, 2131701815 };
  }
  
  public static Drawable a(Context paramContext, aoie paramaoie)
  {
    switch (paramaoie.id)
    {
    default: 
      return null;
    case 1001: 
      return paramContext.getResources().getDrawable(2130847062);
    case 1004: 
      return paramContext.getResources().getDrawable(2130847063);
    case 1003: 
      return paramContext.getResources().getDrawable(2130847064);
    }
    return paramContext.getResources().getDrawable(2130847065);
  }
  
  public static ArrayList<aoie> dP()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      aoie localaoie = new aoie();
      localaoie.id = ov[i];
      localaoie.order = i;
      localaoie.bgColor = COLORS[i];
      localaoie.title = acfp.m(ow[i]);
      localaoie.dOB = jf[i];
      localaoie.subTitle = acfp.m(ox[i]);
      localArrayList.add(localaoie);
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(@Nullable aoie paramaoie)
  {
    if (paramaoie == null) {
      return;
    }
    this.cLF = paramaoie.cLF;
    this.dOC = paramaoie.dOC;
    this.Bj = paramaoie.Bj;
  }
  
  public String getSubTitle()
  {
    if (this.cLF) {
      return this.dOC + acfp.m(dOA) + this.title;
    }
    return this.subTitle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoie
 * JD-Core Version:    0.7.0.1
 */