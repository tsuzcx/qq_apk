class ajmc
  implements agzl
{
  ajmc(ajlu paramajlu, ajlp paramajlp) {}
  
  public void Ke(boolean paramBoolean)
  {
    ajlu.a(this.e, this.b, paramBoolean);
  }
  
  public void Kf(boolean paramBoolean) {}
  
  public void onUpdateProgress(int paramInt)
  {
    if ((this.b != null) && (this.b.a != null))
    {
      String str = this.b.a.vW();
      ajlq localajlq = this.e.a(str);
      if ((localajlq != null) && (!localajlq.isCompleted))
      {
        localajlq.progress = paramInt;
        this.e.a(str, localajlq);
        ajlu.a(this.e, localajlq, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmc
 * JD-Core Version:    0.7.0.1
 */