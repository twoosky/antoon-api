package kr.co.antoon.discussion.application;

import kr.co.antoon.discussion.domain.Discussion;
import kr.co.antoon.discussion.infrastructure.DiscussionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class DiscussionServiceTest {
    @Mock
    private DiscussionRepository discussionRepository;

    @InjectMocks
    private DiscussionService discussionService;

    private final Long MEMBER_ID = 1L;
    private final Long WEBTOON_ID = 1L;
    private final String CONTENT = "TEST CONTENT";
    private final Long DISCUSSION_ID = 1L;

    @Test
    public void 종목토론방_댓글_생성하기() {
        // given
        Discussion expected = Discussion.builder()
                .memberId(MEMBER_ID)
                .webtoonId(WEBTOON_ID)
                .content(CONTENT)
                .build();

        Mockito.when(discussionRepository.save(any()))
                .thenReturn(expected);

        // when
        var actual = discussionService.save(MEMBER_ID, WEBTOON_ID, CONTENT);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 종목토론방_댓글_상세조회() {
        // given
        Discussion expected = Discussion.builder()
                .memberId(MEMBER_ID)
                .webtoonId(WEBTOON_ID)
                .content(CONTENT)
                .build();

        Mockito.when(discussionRepository.findById(anyLong()))
                .thenReturn(Optional.of(expected));

        // when
        var actual = discussionService.findById(DISCUSSION_ID);

        // then
        assertEquals(
                expected.getContent(),
                actual.content()

        );
    }
}