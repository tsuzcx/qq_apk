package com.tencent.map.core.functions.animation;

import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL10;

public class GLAnimSet
  extends GLAnim
{
  private ArrayList<GLAnim> a = new ArrayList();
  
  public GLAnimSet(GLAnim... paramVarArgs)
  {
    super(0L);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.a.add(paramVarArgs[i]);
      l += paramVarArgs[i].getDuration();
      i += 1;
    }
    this.duration = l;
  }
  
  public void draw(GL10 paramGL10)
  {
    performDraw(paramGL10, 0L);
  }
  
  public boolean isFinished()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (!((GLAnim)localIterator.next()).isFinished()) {
        return false;
      }
    }
    return true;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((GLAnim)localIterator.next()).start();
    }
  }
  
  protected void performDraw(GL10 paramGL10, long paramLong)
  {
    if ((this.a == null) || (this.a.isEmpty())) {}
    GLAnim localGLAnim;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.a.iterator();
      }
      localGLAnim = (GLAnim)localIterator.next();
    } while (localGLAnim.isFinished());
    localGLAnim.draw(paramGL10);
  }
  
  public void start()
  {
    super.start();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((GLAnim)localIterator.next()).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GLAnimSet
 * JD-Core Version:    0.7.0.1
 */