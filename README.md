# image-radio-button-android
Beautiful custom radio button with image functionality

[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![](https://jitpack.io/v/raheemadamboev/image-radio-button-android.svg)](https://jitpack.io/#raheemadamboev/image-radio-button-android)

Light library that adds image to a beautiful custom radio button. You can easily add image to radio button. Integration is very easy and many popular Android applications are using this library.

## How To use

Add it in your root **build.gradle** at the end of repositories:
```groovy
allprojects {
  repositories {
	  maven { url 'https://jitpack.io' }
  }
}
```  

Include below dependency in build.gradle of application and sync it:
```groovy
implementation 'com.github.raheemadamboev:image-radio-button-android:1.0.2'
```

Add **GravityRadioGroup** to your XML layout:
```xml
<xyz.teamgravity.imageradiobutton.GravityRadioGroup
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
```

Add **GravityImageRadioButton** inside the **GravityRadioGroup** and set **compulsory** attributes below:

```xml
<xyz.teamgravity.imageradiobutton.GravityRadioGroup
  ...
 >

<xyz.teamgravity.imageradiobutton.GravityImageRadioButton
            android:id="@+id/android_b"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:padding="20dp"
            app:image="@drawable/android"
            app:pressedBackgroundDrawable="@drawable/background_shape_preset_button_pressed"
            app:pressedTextColor="@color/white"
            app:unpressedText="Android"
            app:unpressedTextColor="@color/black" />
            
</xyz.teamgravity.imageradiobutton.GravityRadioGroup>
```

**Attributes:**

| Attribute                             | Type          | Usage                                                                |
| --------------------------------------| ------------- | -------------------------------------------------------------------- |
| `app:image`                           | drawable      | Image drawable that is shown                                         |
| `app:pressedBackgroundDrawable`       | drawable      | Drawable that is shown when radio button is pressed/checked          |
| `app:pressedTextColor`                | color         | Color of text when radio button is pressed/checked                   |
| `app:unpressedText`                   | string        | String to display in text                                            |
| `app:unpressedTextColor`              | color         | Regular color of text when radio button is not pressed/checked       | 

## Demo application

<img src="https://github.com/raheemadamboev/image-radio-button-android/blob/master/background.gif" alt="sample" title="sample" width="440" height="456" align="left" vspace="24" />

Programming pictures are placed with the help of this library in this demo application. When radio button clicked, its text gets shown in Toast.

<a href="https://github.com/raheemadamboev/image-radio-button-android/blob/master/app-debug.apk">Download demo</a>
