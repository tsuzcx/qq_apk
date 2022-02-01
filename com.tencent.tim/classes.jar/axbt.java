class axbt
  implements axcc.b
{
  axbt(axbr paramaxbr, axcc.b paramb) {}
  
  public void a(axbu paramaxbu, int paramInt)
  {
    if (this.b != null) {
      this.b.a(paramaxbu, paramInt);
    }
  }
  
  public void a(axbu paramaxbu, boolean paramBoolean)
  {
    axbu localaxbu = axbr.a(this.this$0, paramaxbu);
    if (localaxbu != null) {
      localaxbu.usable = axbr.b(paramaxbu);
    }
    if (this.b != null)
    {
      this.b.a(paramaxbu, paramBoolean);
      if (localaxbu != null) {
        axiy.i("AEMaterialManager", "【END】onDownloadFinish :" + localaxbu.id);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbt
 * JD-Core Version:    0.7.0.1
 */