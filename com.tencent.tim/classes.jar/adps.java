import com.tencent.mobileqq.ark.ArkAppCenter;
import java.io.File;
import java.util.Locale;

class adps
  implements adpq.c
{
  adps(adpq paramadpq, adpq.e parame, adpq.a parama, String paramString1, adpq.c paramc, String paramString2) {}
  
  public void GG(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b.success = false;
    }
    synchronized (this.b)
    {
      adpq.e locale2 = this.b;
      int i = locale2.taskCount - 1;
      locale2.taskCount = i;
      if (i > 0)
      {
        ArkAppCenter.r("ArkApp.Dict.Update", String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.jdField_a_of_type_Adpq$a.name, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      ArkAppCenter.r("ArkApp.Dict.Update", String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.b.success) }));
      if (!this.b.success)
      {
        aqhq.cn(this.buW);
        this.jdField_a_of_type_Adpq$c.GG(false);
        return;
      }
    }
    if (!adpq.aJ(adpo.jU(this.buX), new File(this.buW).getParent()))
    {
      ArkAppCenter.r("ArkApp.Dict.Update", "updateWordDict, renameDictDirAfterUpdateSuccess fail");
      this.jdField_a_of_type_Adpq$c.GG(false);
      return;
    }
    this.jdField_a_of_type_Adpq$c.GG(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adps
 * JD-Core Version:    0.7.0.1
 */