/**
 * Welcome to your Workbox-powered service worker!
 *
 * You'll need to register this file in your web app and you should
 * disable HTTP caching for this file too.
 * See https://goo.gl/nhQhGp
 *
 * The rest of the code is auto-generated. Please don't update this file
 * directly; instead, make changes to your Workbox build configuration
 * and re-run your build process.
 * See https://goo.gl/2aRDsh
 */

importScripts("https://storage.googleapis.com/workbox-cdn/releases/4.3.1/workbox-sw.js");

self.addEventListener('message', (event) => {
  if (event.data && event.data.type === 'SKIP_WAITING') {
    self.skipWaiting();
  }
});

/**
 * The workboxSW.precacheAndRoute() method efficiently caches and responds to
 * requests for URLs in the manifest.
 * See https://goo.gl/S9QRab
 */
self.__precacheManifest = [
  {
    "url": "404.html",
    "revision": "88e8aaf6e73e837dffaf80bd72455b9f"
  },
  {
    "url": "assets/css/0.styles.2c8ae7de.css",
    "revision": "3d370f7949724f6e1c844721ac2f81a7"
  },
  {
    "url": "assets/img/class-diagram.c1d7f2ad.png",
    "revision": "c1d7f2adb788e86047aa07a830029af3"
  },
  {
    "url": "assets/img/search.83621669.svg",
    "revision": "83621669651b9a3d4bf64d1a670ad856"
  },
  {
    "url": "assets/js/1.82977ebd.js",
    "revision": "8343fc02d4605c1290bc51ad3205e5fc"
  },
  {
    "url": "assets/js/10.0e2bde6e.js",
    "revision": "9be90a8b9858ca44a4979853e23f5963"
  },
  {
    "url": "assets/js/13.bec707ea.js",
    "revision": "4dde86029ebe6f05e4b6f74155e68422"
  },
  {
    "url": "assets/js/14.18a30b26.js",
    "revision": "9cdc3a31f1691a79b77b6596b65dbb48"
  },
  {
    "url": "assets/js/15.bb968e71.js",
    "revision": "51b24747286316f887b5c3bff82fe190"
  },
  {
    "url": "assets/js/16.82ba8eda.js",
    "revision": "c4b2029779c218fde5a6e0d5a96a9e66"
  },
  {
    "url": "assets/js/17.9b4f3a35.js",
    "revision": "cbcd696c06d13e715c223e51df28d7eb"
  },
  {
    "url": "assets/js/18.0471f176.js",
    "revision": "b813d926d51cd4f8bbc07d32c7fc3141"
  },
  {
    "url": "assets/js/19.198c0008.js",
    "revision": "0f63de437601040bc394b6994f292e76"
  },
  {
    "url": "assets/js/2.d5928b1d.js",
    "revision": "95858b8ffb7dfe4dc5b32e44b92546e7"
  },
  {
    "url": "assets/js/20.959394f2.js",
    "revision": "5a2c5c79b93c635c9608c1724de56c9c"
  },
  {
    "url": "assets/js/21.b7b37969.js",
    "revision": "b7f8488255f222126a831a11499d89d9"
  },
  {
    "url": "assets/js/22.841917c8.js",
    "revision": "da5fe0268b661f4683582aedd1f0510b"
  },
  {
    "url": "assets/js/23.3100b240.js",
    "revision": "d9a6f7001cee447d996bcc5e8f7fae75"
  },
  {
    "url": "assets/js/24.0c5bd04a.js",
    "revision": "8570eecbcaec6122cb70654bf28c28c1"
  },
  {
    "url": "assets/js/25.9127e45f.js",
    "revision": "f362f33b368fb24d9b4f6159e3bc46a5"
  },
  {
    "url": "assets/js/26.4d0f1ed0.js",
    "revision": "81bf91aa544d9e4f8b5e4663f74de814"
  },
  {
    "url": "assets/js/27.7a36d913.js",
    "revision": "fcadcfac3da2ec60ac0f04487559d6cf"
  },
  {
    "url": "assets/js/28.c49578a2.js",
    "revision": "2e69073b7b283058c52b40830e55170a"
  },
  {
    "url": "assets/js/29.764689b0.js",
    "revision": "ac1cc7010737666af5d63d48bd380d8a"
  },
  {
    "url": "assets/js/3.45105e67.js",
    "revision": "ded6c95e8978755b825001caad06b5fb"
  },
  {
    "url": "assets/js/30.9d251781.js",
    "revision": "2777247f6285264e3dd2d3bb5cd982b1"
  },
  {
    "url": "assets/js/31.80ebaadd.js",
    "revision": "f52c6e6039c0aff27c52c29399ea1909"
  },
  {
    "url": "assets/js/32.ced2f50a.js",
    "revision": "1af524d7865ccb0b54aa706b052fa38a"
  },
  {
    "url": "assets/js/33.d6c72e2e.js",
    "revision": "0cdf830248c14cdddca7723fec562c5f"
  },
  {
    "url": "assets/js/34.c73ff1dd.js",
    "revision": "45e642266d0af824afa53e5a8ae4c9b0"
  },
  {
    "url": "assets/js/35.fc8a3180.js",
    "revision": "ca819592b5f92e25cbab5ba80e4a4fe9"
  },
  {
    "url": "assets/js/36.e705861f.js",
    "revision": "7e7dd6abafdfc466f50f43c2d353e74d"
  },
  {
    "url": "assets/js/37.44664c8f.js",
    "revision": "95cf799d0a37687a9ece5039bafe6339"
  },
  {
    "url": "assets/js/38.10ab0829.js",
    "revision": "fefd5e21ce3129530762c3081df71112"
  },
  {
    "url": "assets/js/39.11ce89b0.js",
    "revision": "0f11ce17dca0dbdae61d15ad6917f213"
  },
  {
    "url": "assets/js/4.ff2cd110.js",
    "revision": "0f98eaf6b3121659786d87ba8f771054"
  },
  {
    "url": "assets/js/41.8122f54c.js",
    "revision": "9df36c35abf8c6ed69d25990a5a97d3f"
  },
  {
    "url": "assets/js/5.ed988792.js",
    "revision": "5f4e6dcdd67bf3528b9811d9b73533e5"
  },
  {
    "url": "assets/js/6.cf7fc076.js",
    "revision": "cedb52623221bcfb7d93c3d19ba11c72"
  },
  {
    "url": "assets/js/7.98446471.js",
    "revision": "e1414fbd2d146fd13f08954d82f94c8b"
  },
  {
    "url": "assets/js/8.f987943d.js",
    "revision": "6c853ae2eed42697e83d5d1df99e953c"
  },
  {
    "url": "assets/js/9.26686630.js",
    "revision": "3f0b1a387beb72e5562d46824a17c997"
  },
  {
    "url": "assets/js/app.4ae8db41.js",
    "revision": "7f7fdb63861a7f9c2c5d3dad7c9b3e42"
  },
  {
    "url": "assets/js/vendors~docsearch.dfe73048.js",
    "revision": "41b5c218d26e5dcb34837f1d7ffd2341"
  },
  {
    "url": "conclusion/index.html",
    "revision": "76836b11362af3c4f99340072e58de53"
  },
  {
    "url": "design/index.html",
    "revision": "7e78e751b1afecc1ec1f59b4d6007494"
  },
  {
    "url": "index.html",
    "revision": "5236fad4d946bba5e5672077726cd7eb"
  },
  {
    "url": "intro/index.html",
    "revision": "c3c6a09c0a0b823627eb952b43856457"
  },
  {
    "url": "license.html",
    "revision": "70a2edbdcd1a16b29dc6ec11e14ab937"
  },
  {
    "url": "myAvatar.png",
    "revision": "b76db1e62eb8e7fca02a487eb3eac10c"
  },
  {
    "url": "requirements/index.html",
    "revision": "f52510a09bedb882c4020912b4e9113b"
  },
  {
    "url": "requirements/stakeholders-needs.html",
    "revision": "6b91d1fc24dd6f918182b9c20ab12bac"
  },
  {
    "url": "requirements/state-of-the-art.html",
    "revision": "f6eec18253ec75db72adf1408f071fc3"
  },
  {
    "url": "software/index.html",
    "revision": "34e10c352d5a0ded1d1151ab4c394f97"
  },
  {
    "url": "test/index.html",
    "revision": "c4d2b3ab816033401d1f1d1ba3de787c"
  },
  {
    "url": "use cases/index.html",
    "revision": "ede787f832d5a13a5aa8d40c8a96025d"
  }
].concat(self.__precacheManifest || []);
workbox.precaching.precacheAndRoute(self.__precacheManifest, {});
addEventListener('message', event => {
  const replyPort = event.ports[0]
  const message = event.data
  if (replyPort && message && message.type === 'skip-waiting') {
    event.waitUntil(
      self.skipWaiting().then(
        () => replyPort.postMessage({ error: null }),
        error => replyPort.postMessage({ error })
      )
    )
  }
})
