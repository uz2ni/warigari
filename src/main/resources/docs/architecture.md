# 패키지 구조 설명

## 아키텍처 개요

DDD(도메인 주도 설계) + 클린 아키텍처(헥사고날) 기반으로 설계되었습니다.
도메인별로 패키지를 분리하고, 각 도메인 내부에서 레이어를 나눕니다.

## 의존성 방향

```
adapter/in (Controller)
    ↓
application/port/in (UseCase 인터페이스)
    ↓
application/service (비즈니스 로직)
    ↓
application/port/out (Repository 인터페이스)
    ↓
adapter/out (JPA / 외부 API)

domain (순수 도메인 객체) ← 어디서도 의존받지 않음
```

## 패키지 구조

```
com.example.warigari
│
├── common/                         공통 모듈
│   ├── exception/
│   │   ├── BusinessException       비즈니스 예외 기반 클래스
│   │   └── GlobalExceptionHandler  전역 예외 처리 (@RestControllerAdvice)
│   └── response/
│       └── ApiResponse             공통 API 응답 포맷 { success, data, message }
│
└── product/                        상품 도메인
    ├── adapter/
    │   ├── in/
    │   │   └── ProductController   HTTP 요청 수신, UseCase 호출
    │   └── out/
    │       └── ProductJpaAdapter   ProductPort 구현체, DB 연동 담당
    ├── application/
    │   ├── port/
    │   │   ├── in/
    │   │   │   └── ProductUseCase  입력 포트 (서비스가 구현)
    │   │   └── out/
    │   │       └── ProductPort     출력 포트 (어댑터가 구현)
    │   └── service/
    │       └── ProductService      핵심 비즈니스 로직
    └── domain/
        ├── Product                 상품 도메인 객체 (순수 POJO)
        └── Category                카테고리 도메인 객체 (순수 POJO)
```

## 레이어별 역할

| 레이어 | 역할 | 의존 가능한 것 |
|--------|------|---------------|
| `domain` | 순수 비즈니스 객체, 규칙 | 없음 |
| `application/port` | 입출력 인터페이스 정의 | domain |
| `application/service` | 비즈니스 로직 구현 | port, domain |
| `adapter/in` | HTTP 요청/응답 처리 | port/in |
| `adapter/out` | DB, 외부 API 연동 | port/out |
| `common` | 전역 예외, 공통 응답 포맷 | - |

## 새 도메인 추가 방법

`product` 구조를 그대로 복사해서 도메인명만 변경합니다.

```
{domain}/
├── adapter/in/{Domain}Controller
├── adapter/out/{Domain}JpaAdapter
├── application/port/in/{Domain}UseCase
├── application/port/out/{Domain}Port
├── application/service/{Domain}Service
└── domain/{Domain}.java
```
