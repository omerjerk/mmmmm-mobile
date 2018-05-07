package com.mmmmm;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.aakashns.reactnativedialogs.ReactNativeDialogsPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.peel.react.TcpSocketsModule;
import com.peel.react.rnos.RNOSModule;
import com.rnfs.RNFSPackage;
import com.bitgo.randombytes.RandomBytesPackage;
import com.staltz.react.workers.WorkersPackage;
import com.staltz.reactnativenode.RNNodePackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.reactnativenavigation.NavigationApplication;
import com.reactnativedocumentpicker.ReactNativeDocumentPicker;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends NavigationApplication {

  @Override
  public boolean isDebug() {
    // Make sure you are using BuildConfig from your own application
    return BuildConfig.DEBUG;
  }

  protected List<ReactPackage> getPackages() {
    // Add additional packages you require here
    // No need to add RnnPackage and MainReactPackage
    return Arrays.<ReactPackage>asList(
      new MainReactPackage(),
      new ReactNativeDialogsPackage(),
      new VectorIconsPackage(),
      new TcpSocketsModule(),
      new RNOSModule(),
      new RNFSPackage(),
      new RandomBytesPackage(),
      new RNNodePackage(),
      new ReactNativeDocumentPicker(),
      new WorkersPackage(
        new TcpSocketsModule(),
        new RNOSModule(),
        new RNFSPackage(),
        new RandomBytesPackage()
      )
    );
  }

  @Override
  public List<ReactPackage> createAdditionalReactPackages() {
    return getPackages();
  }
}
