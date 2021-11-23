# AndroidBroadcastReceiverExample
Uygulamalar arası BroadcastReceiver kullanımı

AndroidBroadcastReceiverExample, bir uygulamanın diğer bir uygulama tarafından broadcastreceiver kullanılarak nasıl kontrol edilebileceğine dair bir uygulamadır.

BroadcastReceiverPermissionApp02 uygulamasında ActivityRunningControl adlı bir servis çalışmaktadır.Bu servis her 5000ms de bir arka planda mı yoksa ön planda mı çalıştığını kontrol eder ve "my.signal" yayını ve "my.permission" izni ile diğer uygulamalara yayın yapar.

BroadcastReceiverPermissionApp01 uygulaması ise "my.signal" yanını BroadcastingClass sınıfının onReceiver methodu ile yakalayıp gelen yayındaki verileri işlemektedir.

Bu iki uygulamanın amacı BroadcastReceiverPermissionApp02 uygulaması arka plana düşerse BroadcastReceiverPermissionApp01 uygulaması tarafından tekrar ön plana alınmaktadır.

# Önemli Alanlar #

"com.example.broadcastreceiverpermissionapp02" açmak istediğimiz uygulamanın package namedir.

BroadcastReceiverPermissionApp02  yayıncı uygulama olduğundan yayını için bir izin oluşturmalıdır.Bununda Manifest dosyası altında tanımlaması yapılmaktadır.

	<permission android:name="my.permission" android:protectionLevel="signature"></permission>
   
BroadcastReceiverPermissionApp01 yayını dinleyebilmek için BroadcastReceiverPermissionApp02'in oluşturduğu izini tanımlamalıdır.

	<uses-permission android:name="my.permission" />
    
   
Servis tanımlamaları ve servisi aktif etme durumlarına dikkat edilmelidir.

	<service android:name=".ActivityRunningControl"/>
  
Receiver tanımlamalarına dikkat edilmelidir.

	<receiver android:name=".BroadcastingClass" android:exported="true">
			<intent-filter>
				<action android:name="my.signal"></action>
			</intent-filter>
	</receiver>
   
   
Bir uygulamayı diğer uygulamadan erişmek için tanımlamaya dikkat edilmelidir.

	<queries>
		<package android:name="com.example.broadcastreceiverpermissionapp02" />
	</queries>
   
   
   
   
  

	
