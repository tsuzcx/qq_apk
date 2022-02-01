package com.tencent.hydevteam.pluginframework.pluginmanager;

import java.io.File;

class TargetManager
{
  final File a;
  final File b;
  
  TargetManager(File paramFile)
  {
    this.a = new File(paramFile, "TargetFolder");
    this.b = new File(this.a, "tmp");
    if ((this.a.exists()) && (!this.a.isDirectory())) {
      throw new IllegalArgumentException(this.a.getAbsolutePath() + "已存在且不是目录");
    }
    if (!this.a.exists()) {
      this.a.mkdirs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.TargetManager
 * JD-Core Version:    0.7.0.1
 */