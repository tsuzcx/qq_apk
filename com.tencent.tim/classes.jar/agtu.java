import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

class agtu
  implements smq.j
{
  agtu(agtt paramagtt, boolean paramBoolean, String paramString, short paramShort) {}
  
  public void fe(List<agxi.a> paramList)
  {
    if (this.a.a.a != null)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        break label126;
      }
      this.a.a.a.jM(-1000L);
    }
    while (paramList != null)
    {
      anot.a(this.a.a.mAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_suc", 0, 0, "" + this.a.a.c.b().TroopUin, "", ahav.lb(this.a.a.getFileName()), "1");
      return;
      label126:
      this.a.a.a.a(paramList, this.a.a.str_download_dns, this.a.a.aEI, this.a.a.aEJ, this.a.a.aEK, this.cfg, this.bHZ, this.al);
    }
    anot.a(this.a.a.mAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, "" + this.a.a.c.b().TroopUin, "-1", ahav.lb(this.a.a.getFileName()), "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agtu
 * JD-Core Version:    0.7.0.1
 */