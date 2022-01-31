package android.support.v4.app;

final class BackStackRecord$Op
{
  int cmd;
  int enterAnim;
  int exitAnim;
  Fragment fragment;
  int popEnterAnim;
  int popExitAnim;
  
  BackStackRecord$Op() {}
  
  BackStackRecord$Op(int paramInt, Fragment paramFragment)
  {
    this.cmd = paramInt;
    this.fragment = paramFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackRecord.Op
 * JD-Core Version:    0.7.0.1
 */