package kr.co.antoon.recommendation.application;

import kr.co.antoon.recommendation.domain.RecommendationCount;
import kr.co.antoon.recommendation.infrastructure.RecommendationCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecommendationCountService {
    private final RecommendationCountRepository recommendationCountRepository;

    @Transactional(readOnly = true)
    public Optional<RecommendationCount> findByWebtoonId(Long webtoonId) {
        return recommendationCountRepository.findByWebtoonId(webtoonId);
    }

    @Transactional
    public RecommendationCount save(Long webtoonId, int joinCount) {
        return recommendationCountRepository.save(
                new RecommendationCount(
                        webtoonId,
                        joinCount
                )
        );
    }

    @Transactional(readOnly = true)
    public Optional<RecommendationCount> findTop1ByWebtoonIdOrderByCreatedAtDesc(Long webtoonId) {
        return recommendationCountRepository.findTop1ByWebtoonIdOrderByIdDesc(webtoonId);
    }
}
