class rpi
  implements rpg.d
{
  rpi(rpg.j paramj) {}
  
  public void a(rpg.i parami, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      rpg.i[] arrayOfi = this.this$0.a();
      j = arrayOfi.length;
      i = 0;
      while (i < j)
      {
        rpg.i locali = arrayOfi[i];
        if (locali != parami) {
          locali.setSelect(false);
        }
        i += 1;
      }
    }
    parami = this.this$0.a();
    int j = parami.length;
    for (;;)
    {
      if ((i >= j) || (parami[i].isSelected())) {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpi
 * JD-Core Version:    0.7.0.1
 */