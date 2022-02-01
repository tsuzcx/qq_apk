import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

class atzv
  implements smq.j
{
  atzv(atzu paramatzu) {}
  
  public void fe(List<agxi.a> paramList)
  {
    if (this.a.a.a != null) {
      this.a.a.a.b(paramList, this.a.a.str_download_dns, this.a.a.aEI, this.a.a.aEJ, this.a.a.aEK);
    }
    if (paramList != null)
    {
      anot.a(this.a.a.mAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_suc", 0, 0, "" + this.a.a.c.b().TroopUin, "", audx.lb(this.a.a.getFileName()), "1");
      return;
    }
    anot.a(this.a.a.mAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, "" + this.a.a.c.b().TroopUin, "-1", audx.lb(this.a.a.getFileName()), "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzv
 * JD-Core Version:    0.7.0.1
 */